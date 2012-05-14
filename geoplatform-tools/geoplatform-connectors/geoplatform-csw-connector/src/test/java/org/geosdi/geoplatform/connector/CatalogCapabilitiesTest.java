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
package org.geosdi.geoplatform.connector;

import org.geosdi.geoplatform.connector.CatalogVersionException;
import org.geosdi.geoplatform.connector.CatalogGetCapabilitiesBean;
import org.geosdi.geoplatform.connector.GPCSWServerConnector;
import org.geosdi.geoplatform.connector.GPCSWConnectorBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.geosdi.geoplatform.connector.api.capabilities.model.csw.CatalogCapabilities;
import org.geosdi.geoplatform.connector.server.request.CatalogGetCapabilitiesRequest;
import org.geosdi.geoplatform.xml.csw.v202.CapabilitiesType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CatalogCapabilitiesTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Autowired
    private CatalogGetCapabilitiesBean catalogCapabilitiesBean;

    @Test
    public void testCapabilitiesV201WithoutVersionControl() {
        try {
            CatalogCapabilities catalogGetCapabilities = catalogCapabilitiesBean.bindUrlWithoutVersionControl(
                    "http://catalogocentrale.nsdi.it/geonetwork/srv/en/csw?SERVICE");

            logger.info(
                    "@@@@@@@@@@@@@@@ CATALOG CAPABILITIES BEAN V_2.0.1 WITHOUT VERSION CONTROL"
                    + "@@@@@@@@@@@@@@@@@@@@@@@ " + catalogGetCapabilities);

        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException @@@@@@@@@@@@@@ " + ex);
        } catch (IOException es) {
            logger.error("IOException @@@@@@@@@@@@@@ " + es);
        }
    }

    @Test
    public void testCapabilitiesV201() {
        try {
            CatalogCapabilities catalogGetCapabilities = catalogCapabilitiesBean.bindUrl(
                    "http://catalogocentrale.nsdi.it/geonetwork/srv/en/csw");

            logger.info(
                    "@@@@@@@@@@@@@@@ CATALOG CAPABILITIES BEAN V_2.0.1"
                    + "@@@@@@@@@@@@@@@@@@@@@@@ " + catalogGetCapabilities);

        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException @@@@@@@@@@@@@@ " + ex);
        } catch (IOException es) {
            logger.error("IOException @@@@@@@@@@@@@@ " + es);
        } catch (CatalogVersionException ve) {
            logger.error("CatalogVersionException @@@@@@@@@@@@ " + ve);
        }
    }

    @Test
    public void testCapabilitiesV202() throws Exception {
        try {

            CatalogCapabilities catalogGetCapabilities = catalogCapabilitiesBean.bindUrl(
                    "http://rsdi.regione.basilicata.it/Catalogo/srv/en/csw");

            logger.info(
                    "CATALOG CAPABILITIES BEAN V_2.0.2 @@@@@@@@@@@"
                    + "@@@@@@@@@@@@@@@@@@@@@@@ " + catalogGetCapabilities);

        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException @@@@@@@@@@@@@@ " + ex);
        } catch (IOException es) {
            logger.error("IOException @@@@@@@@@@@@@@ " + es);
        } catch (CatalogVersionException ve) {
            logger.error("CatalogVersionException @@@@@@@@@@@@ " + ve);
        }
    }

    @Test
    public void testCSW_ESRI() {
        try {

            CatalogCapabilities catalogGetCapabilities = catalogCapabilitiesBean.bindUrl(
                    "https://snipc.protezionecivile.it/geoportal/csw/discovery");

            logger.info(
                    "CATALOG CAPABILITIES ESRI @@@@@@@@@@@"
                    + "@@@@@@@@@@@@@@@@@@@@@@@ " + catalogGetCapabilities);


        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException @@@@@@@@@@@@@@ " + ex);
        } catch (IOException es) {
            logger.error("IOException @@@@@@@@@@@@@@ " + es);
        } catch (CatalogVersionException ve) {
            logger.error("CatalogVersionException @@@@@@@@@@@@ " + ve);
        }
    }

    @Test
    public void testGetCapabilitiesWithConnector() throws Exception {
        URL url = new URL("http://150.146.160.152/geonetwork/srv/en/csw");
        GPCSWServerConnector serverConnector = GPCSWConnectorBuilder.newConnector().
                withServerUrl(url).build();

        CatalogGetCapabilitiesRequest<CapabilitiesType> request = serverConnector.createGetCapabilitiesRequest();

        CapabilitiesType response = request.getResponse();

        logger.info("CSW GET_CAPABILITIES VERSION @@@@@@@@@@@@@@@@@@@@@@@ {}",
                response.getVersion());
    }
}