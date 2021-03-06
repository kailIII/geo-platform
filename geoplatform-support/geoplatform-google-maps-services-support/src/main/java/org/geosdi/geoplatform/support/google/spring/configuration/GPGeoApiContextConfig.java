/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.support.google.spring.configuration;

import com.google.common.base.Preconditions;
import net.jcip.annotations.Immutable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Immutable
@Component(value = "gpGeoApiContextConfig")
public class GPGeoApiContextConfig implements GeoApiContextConfig {

    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.apiKey:@null}")
    private String apiKey;
    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.connection.timeout:@null}")
    private Long connectionTimeout;
    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.read.timeout:@null}")
    private Long readTimeout;
    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.write.timeout:@null}")
    private Long writeTimeout;
    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.retry.timeout:@null}")
    private Long retryTimeout;
    @Value(value = "gpGoogleServicesConfigurator{gp.googleservices.query.rate.limit:@null}")
    private Integer queryRateLimit;

    @Override
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public Long getConnectionTimeout() {
        return this.connectionTimeout = ((this.connectionTimeout != null)
                ? this.connectionTimeout : 10);
    }

    @Override
    public Long getReadTimeout() {
        return this.readTimeout = ((this.readTimeout != null)
                ? this.readTimeout : 10);
    }

    @Override
    public Long getWriteTimeout() {
        return this.writeTimeout = ((this.writeTimeout != null) ? this.writeTimeout : 0);
    }

    @Override
    public Long getRetryTimeout() {
        return this.retryTimeout = ((this.retryTimeout != null)
                ? this.retryTimeout : 60);
    }

    @Override
    public Integer getQueryRateLimit() {
        return this.queryRateLimit = ((this.queryRateLimit != null)
                ? this.queryRateLimit : 10);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Preconditions.checkArgument((this.apiKey != null)
                || !(this.apiKey.isEmpty()), "The Parameter ApiKey must not be "
                + "null or an Empty String");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" + "apiKey = " + apiKey
                + ", connectionTimeout = " + getConnectionTimeout()
                + ", readTimeout = " + getReadTimeout()
                + ", writeTimeout = " + getWriteTimeout()
                + ", retryTimeout = " + getRetryTimeout()
                + ", queryRateLimit = " + getQueryRateLimit() + '}';
    }
}
