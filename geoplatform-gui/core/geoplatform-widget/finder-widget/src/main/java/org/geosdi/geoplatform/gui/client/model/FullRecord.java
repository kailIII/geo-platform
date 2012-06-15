/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2012 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.gui.client.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.geosdi.geoplatform.gui.configuration.map.client.geometry.BBoxClientInfo;
import org.geosdi.geoplatform.gui.configuration.map.client.layer.GPLayerType;
import org.geosdi.geoplatform.gui.model.GPShortLayerBean;
import org.geosdi.geoplatform.gui.responce.OnlineResourceProtocolType;
import org.geosdi.geoplatform.gui.responce.URIDTO;

/**
 * Full Record for CSW request.
 *
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
public class FullRecord extends AbstractRecord implements GPShortLayerBean {

    private static final long serialVersionUID = 7344635200928287521L;
    //
    private BBoxClientInfo bBox;
    private String crs;
    private Map<OnlineResourceProtocolType, URIDTO> uriMap;
    //
    private WMSShortLayerBean wmsLayer;

    @Override
    public BBoxClientInfo getBBox() {
        return bBox;
    }

    public void setBBox(BBoxClientInfo bBox) {
        this.bBox = bBox;
    }

    @Override
    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public Map<OnlineResourceProtocolType, URIDTO> getUriMap() {
        return uriMap;
    }

    public void setUriMap(Map<OnlineResourceProtocolType, URIDTO> uriMap) {
        this.uriMap = uriMap;
        this.wmsLayer = new WMSShortLayerBean(uriMap);
    }

    public boolean isForWMSGetMapRequest() {
        return this.isForByProtocol(OnlineResourceProtocolType.LIST_WMS_GET_MAP_REQUEST);
    }

    public boolean isForDownload() {
        return this.isForByProtocol(OnlineResourceProtocolType.LIST_DOWNLOAD);
    }

    public boolean isForLink() {
        return this.isForByProtocol(OnlineResourceProtocolType.LIST_LINK);
    }

    private boolean isForByProtocol(List<OnlineResourceProtocolType> protocolList) {
        for (OnlineResourceProtocolType protocol : protocolList) {
            if (uriMap.get(protocol) != null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("FullRecord {");
        str.append(super.toString());
        str.append(", bBox =").append(bBox);
        str.append(", crs =").append(crs);
        str.append(", uriList =").append(getUriMap());
        return str.append('}').toString();
    }

    @Override
    public GPLayerType getLayerType() {
        return GPLayerType.RASTER;
    }

    @Override
    public String getLayerTitle() {
        return wmsLayer == null ? "" : wmsLayer.getTitle();
    }

    @Override
    public String getLayerName() {
        return wmsLayer == null ? "" : wmsLayer.getName();
    }

    @Override
    public String getLayerLabel() {
        return wmsLayer == null ? "" : wmsLayer.getLabel();
    }

    @Override
    public String getLayerDataSource() {
        return wmsLayer == null ? "" : wmsLayer.getDataSource();
    }

    static class WMSShortLayerBean implements Serializable {

        private static final long serialVersionUID = 9072958822410211537L;
        //
        private URIDTO uriWMS;

        WMSShortLayerBean() {
        }

        WMSShortLayerBean(Map<OnlineResourceProtocolType, URIDTO> uriMap) {
            for (OnlineResourceProtocolType wmsProtocol : OnlineResourceProtocolType.LIST_WMS_GET_MAP_REQUEST) {
                URIDTO uri = uriMap.get(wmsProtocol);
                if (uri != null) {
                    uriWMS = uri;
                    return;
                }
            }
        }

        public String getTitle() {
            return uriWMS == null ? "" : uriWMS.getDescription();
        }

        public String getName() {
            return uriWMS == null ? "" : uriWMS.getName();
        }

        public String getLabel() {
            return uriWMS == null ? "" : this.retrieveLabel(uriWMS.getName());
        }

        public String getDataSource() {
            return uriWMS == null ? "" : this.retrieveDataSource(uriWMS.getServiceURL());
        }

        private String retrieveLabel(String name) {
            int ind = name.indexOf(":");
            if (ind != -1) {
                return name.substring(ind + 1);
            }
            return name;
        }

        private String retrieveDataSource(String serviceURL) {
            int ind = serviceURL.indexOf("?");
            if (ind != -1) {
                return serviceURL.substring(0, ind);
            }
            return serviceURL;
        }
    }
}