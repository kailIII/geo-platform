/**
 *
 * geo-platform Rich webgis framework http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is making a
 * combined work based on this library. Thus, the terms and conditions of the
 * GNU General Public License cover the whole combination.
 *
 * As a special exception, the copyright holders of this library give you
 * permission to link this library with independent modules to produce an
 * executable, regardless of the license terms of these independent modules, and
 * to copy and distribute the resulting executable under terms of your choice,
 * provided that you also meet, for each linked independent module, the terms
 * and conditions of the license of that module. An independent module is a
 * module which is not derived from or based on this library. If you modify this
 * library, you may extend this exception to your version of the library, but
 * you are not obligated to do so. If you do not wish to do so, delete this
 * exception statement from your version.
 */
package org.geosdi.geoplatform.services;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.geosdi.geoplatform.core.dao.GPServerDAO;
import org.geosdi.geoplatform.core.model.GPBBox;
import org.geosdi.geoplatform.core.model.GPLayerInfo;
import org.geosdi.geoplatform.core.model.GeoPlatformServer;
import org.geosdi.geoplatform.exception.ResourceNotFoundFault;
import org.geosdi.geoplatform.request.RequestByID;
import org.geosdi.geoplatform.response.RasterLayerDTO;
import org.geosdi.geoplatform.response.ServerDTO;
import org.geotools.data.ows.CRSEnvelope;
import org.geotools.data.ows.Layer;
import org.geotools.data.ows.StyleImpl;
import org.geotools.data.ows.WMSCapabilities;
import org.geotools.data.wms.WebMapServer;
import org.geotools.ows.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPWMSServiceImpl implements GPWMSService {

    private final static String EPSG_4326 = "EPSG:4326";
    private final static String EPSG_3857 = "EPSG:3857";
    private final static String EPSG_GOOGLE = "EPSG:900913";
    private Logger logger = LoggerFactory.getLogger(
            GPWMSServiceImpl.class);
    // DAO
    private GPServerDAO serverDao;
    private static final String GEB = "earthbuilder.google.com";

    public GPWMSServiceImpl() {
    }

    @Override
    public ServerDTO getCapabilities(String serverUrl, RequestByID request,
            String token, String authkey) throws ResourceNotFoundFault {
        GeoPlatformServer server = serverDao.find(request.getId());
        if (server == null) {
            throw new ResourceNotFoundFault("Server has been deleted",
                    request.getId());
        }
        WMSCapabilities wmsCapabilities = this.getWMSCapabilities(
                serverUrl, token, authkey);
        // server = this.createWMSServerFromService(server,
        // wmsCapabilities.getService());
        // serverDao.merge(server);
        List<RasterLayerDTO> layers = this.convertToLayerList(
                wmsCapabilities.getLayer(), serverUrl);
        ServerDTO serverDTO = new ServerDTO(server);
        serverDTO.setLayerList(layers);

        return serverDTO;
    }

    @Override
    public ServerDTO getShortServer(String serverUrl)
            throws ResourceNotFoundFault {
        GeoPlatformServer server = serverDao.findByServerUrl(serverUrl);
        if (server == null) {
            throw new ResourceNotFoundFault("Server not found " + serverUrl);
        }

        return new ServerDTO(server);
    }

    private boolean isURLServerAlreadyExists(String serverUrl) {
        return serverDao.findByServerUrl(serverUrl) == null ? false : true;
    }

    private WMSCapabilities getWMSCapabilities(String serverUrl, String token,
            String authkey) throws ResourceNotFoundFault {
        URL serverURL;
        WebMapServer wms;
        WMSCapabilities cap = null;

        String urlServerEdited = this.editServerUrl(serverUrl, token, authkey);
        logger.debug("\nURL Server edited: {}", urlServerEdited);

        try {
            serverURL = new URL(urlServerEdited);
            wms = new WebMapServer(serverURL);
            cap = wms.getCapabilities();

        } catch (MalformedURLException e) {
            logger.error("MalformedURLException: " + e);
            throw new ResourceNotFoundFault("Malformed URL");
        } catch (ServiceException e) {
            logger.error("ServiceException: " + e);
            throw new ResourceNotFoundFault("Invalid URL");
        } catch (IOException e) {
            logger.error("IOException: " + e);
            throw new ResourceNotFoundFault("Inaccessible URL");
        } catch (Exception e) {
            logger.error("Exception: " + e);
            throw new ResourceNotFoundFault("Incorrect URL");
        }
        return cap;
    }

    private String editServerUrl(String urlServer, String token, String authkey) {
        StringBuilder stringBuilder = new StringBuilder(urlServer);
        if (!urlServer.contains("?")) {
            stringBuilder.append("?request=GetCapabilities");
        }

        if (urlServer.contains(GEB)) {
            stringBuilder.append("&access_token=").append(token);
        }
        if (authkey != null) {
            stringBuilder.append("&authkey=").append(authkey);
        }
        return stringBuilder.toString();
    }

    private List<RasterLayerDTO> convertToLayerList(Layer layer,
            String urlServer) {
        List<RasterLayerDTO> shortLayers = Lists.<RasterLayerDTO>newArrayList();

        RasterLayerDTO raster = this.getRasterAndSubRaster(layer, layer, urlServer);
        shortLayers.add(raster);

        return shortLayers;
    }

    private RasterLayerDTO getRasterAndSubRaster(Layer ancestorLayer, Layer layer, String urlServer) {
        RasterLayerDTO raster = this.convertLayerToRaster(ancestorLayer, layer, urlServer);

        List<Layer> subLayerList = layer.getLayerChildren();
        List<RasterLayerDTO> subRasterList = Lists.<RasterLayerDTO>newArrayListWithExpectedSize(
                subLayerList.size());
        raster.setSubLayerList(subRasterList);

        // ADD subRaster
        for (Layer layerIth : subLayerList) {
            RasterLayerDTO rasterIth = this.getRasterAndSubRaster(ancestorLayer, layerIth,
                    urlServer);
            subRasterList.add(rasterIth);
        }

        return raster;
    }

    private RasterLayerDTO convertLayerToRaster(Layer ancestorLayer, Layer layer, String urlServer) {
        RasterLayerDTO raster = new RasterLayerDTO();

        raster.setUrlServer(this.getUrlServer(urlServer));
        raster.setName(layer.getName());
        raster.setAbstractText(layer.get_abstract());
        if (layer.getTitle() == null || layer.getTitle().trim().equals("")) {
            raster.setTitle(layer.getName());
        } else {
            raster.setTitle(layer.getTitle());
        }
        Map<String, CRSEnvelope> additionalBounds = layer.getBoundingBoxes();

        logger.debug("ADDITIONAL BOUNDS ###############################"
                + additionalBounds.toString());

        if (!additionalBounds.isEmpty()) {
            if (additionalBounds.containsKey(EPSG_GOOGLE)
                    || additionalBounds.containsKey(EPSG_3857)) {
                CRSEnvelope env = additionalBounds
                        .get(EPSG_GOOGLE);
                if (env == null) {
                    env = additionalBounds.get(EPSG_3857);
                }
                raster.setBbox(this.createBbox(env));
                raster.setSrs(env.getEPSGCode());
            } else {
                raster.setBbox(this.createBbox(layer.getLatLonBoundingBox()));
                raster.setSrs(EPSG_4326);
            }

        } else {
            additionalBounds = ancestorLayer.getBoundingBoxes();
            if (additionalBounds.containsKey(EPSG_GOOGLE)
                    || additionalBounds.containsKey(EPSG_3857)) {
                CRSEnvelope env = additionalBounds
                        .get(EPSG_GOOGLE);
                if (env == null) {
                    env = additionalBounds.get(EPSG_3857);
                }
                raster.setBbox(this.createBbox(env));
                raster.setSrs(env.getEPSGCode());
                logger.info("GOOGLE");
            } else {
                raster.setBbox(this.createBbox(ancestorLayer.getLatLonBoundingBox()));
                raster.setSrs(EPSG_4326);
                logger.info("4326");
            }

        }

        logger.debug("Raster Name: " + raster.getName());
        logger.debug("Raster BBOX: " + raster.getBbox());
        logger.debug("Raster SRS: " + raster.getSrs());

        if (urlServer.contains(GEB)) {
            if (layer.getLatLonBoundingBox() != null) {
                raster.setBbox(this.createBbox(layer.getLatLonBoundingBox()));
            }
            raster.setSrs(EPSG_4326);
        }

        // Set LayerInfo of Raster Ith
        GPLayerInfo layerInfo = new GPLayerInfo();
        layerInfo.setQueryable(layer.isQueryable());
        if (layer.getKeywords() != null) {
            List<String> keywordList = Arrays.asList(layer.getKeywords());
            if (keywordList.size() > 0) {
                layerInfo.setKeywords(keywordList);
            }
        }
        raster.setLayerInfo(layerInfo);

        // Set Styles of Raster Ith
        List<StyleImpl> stylesImpl = layer.getStyles();
        logger.debug(
                "\n*** Layer \"{}\" has {} SubLayers and {} StyleImpl ***",
                layer.getTitle(), layer.getLayerChildren().size(),
                stylesImpl.size());

        raster.setStyleList(this.createStyleList(stylesImpl));

        return raster;
    }

    private List<ServerDTO> convertToServerList(
            List<GeoPlatformServer> serverList) {
        List<ServerDTO> shortServers = new ArrayList<ServerDTO>(
                serverList.size());
        ServerDTO serverDTOIth = null;
        for (GeoPlatformServer server : serverList) {
            serverDTOIth = new ServerDTO(server);
            shortServers.add(serverDTOIth);
        }
        return shortServers;
    }

    private List<String> createStyleList(List<StyleImpl> stylesImpl) {
        List<String> styleList = new ArrayList<String>(stylesImpl.size());
        for (StyleImpl style : stylesImpl) {
            styleList.add(style.getName());
        }
        return styleList;
    }

    private GPBBox createBbox(CRSEnvelope env) {
        return ((env != null) ? new GPBBox(env.getMinX(), env.getMinY(),
                env.getMaxX(),
                env.getMaxY()) : new GPBBox(-179, -89, 179, 89));
    }

    private String getUrlServer(String urlServer) {
        int index = -1;
        if (urlServer.contains(".map")) {
            index = urlServer.indexOf(".map") + 4;
        } else if (urlServer.contains("mapserv.exe")
                || urlServer.contains("mapserver")
                || urlServer.contains("mapserv")
                || urlServer.contains("usertoken")
                || urlServer.contains("map")) {
            index = urlServer.indexOf("&");
        } else {
            index = urlServer.indexOf("?");
            // index += 1;
        }
        if (index != -1) {
            String newUrl = urlServer.substring(0, index);
            return newUrl;
        }
        return urlServer;
    }

    private double longToSphericalMercatorX(double x) {
        return (x / 180.0) * 20037508.34;
    }

    private double latToSphericalMercatorY(double y) {
        if (y > 85.05112) {
            y = 85.05112;
        }

        if (y < -85.05112) {
            y = -85.05112;
        }

        y = (Math.PI / 180.0) * y;
        double tmp = Math.PI / 4.0 + y / 2.0;
        return 20037508.34 * Math.log(Math.tan(tmp)) / Math.PI;
    }

    public void setServerDao(GPServerDAO serverDao) {
        this.serverDao = serverDao;
    }

}
