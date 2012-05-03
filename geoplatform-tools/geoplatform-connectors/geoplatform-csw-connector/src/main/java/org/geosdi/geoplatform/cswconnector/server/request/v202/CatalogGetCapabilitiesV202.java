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
package org.geosdi.geoplatform.cswconnector.server.request.v202;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.geosdi.geoplatform.connector.protocol.GeoPlatformHTTP;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.cswconnector.server.request.CatalogCSWRequest;
import org.geosdi.geoplatform.cswconnector.server.request.CatalogGetCapabilitiesRequest;
import org.geosdi.geoplatform.xml.csw.CSWServiceEnum;
import org.geosdi.geoplatform.xml.csw.v202.CapabilitiesType;
import org.geosdi.geoplatform.xml.csw.v202.GetCapabilitiesType;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
public class CatalogGetCapabilitiesV202 extends CatalogCSWRequest<CapabilitiesType>
        implements CatalogGetCapabilitiesRequest<CapabilitiesType> {

    public CatalogGetCapabilitiesV202(GPServerConnector server) throws URISyntaxException {
        super(server);
    }

    @Override
    public HttpEntity preparePostEntity()
            throws JAXBException, UnsupportedEncodingException {

        Marshaller marshaller = cswContext.acquireMarshaller();

        GetCapabilitiesType request = new GetCapabilitiesType(CSWServiceEnum.CSW);
        StringWriter writer = new StringWriter();
        marshaller.marshal(request, writer);

        return new StringEntity(writer.toString(),
                GeoPlatformHTTP.CONTENT_TYPE_XML, HTTP.UTF_8);
    }
}