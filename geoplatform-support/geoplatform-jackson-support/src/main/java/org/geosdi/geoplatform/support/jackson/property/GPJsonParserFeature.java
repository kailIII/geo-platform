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
package org.geosdi.geoplatform.support.jackson.property;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public enum GPJsonParserFeature implements
        JacksonSupportConfigFeature<JsonParser.Feature> {

    AUTO_CLOSE_SOURCE_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.AUTO_CLOSE_SOURCE;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    AUTO_CLOSE_SOURCE_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.AUTO_CLOSE_SOURCE;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_COMMENTS_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_COMMENTS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_COMMENTS_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_COMMENTS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_YAML_COMMENTS_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_YAML_COMMENTS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_YAML_COMMENTS_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_YAML_COMMENTS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_UNQUOTED_FIELD_NAMES_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_UNQUOTED_FIELD_NAMES_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_SINGLE_QUOTES_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_SINGLE_QUOTES;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_SINGLE_QUOTES_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_SINGLE_QUOTES;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_UNQUOTED_CONTROL_CHARS_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_UNQUOTED_CONTROL_CHARS_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_NUMERIC_LEADING_ZEROS_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_NUMERIC_LEADING_ZEROS_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_NON_NUMERIC_NUMBERS_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    ALLOW_NON_NUMERIC_NUMBERS_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    STRICT_DUPLICATE_DETECTION_ENABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.TRUE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.STRICT_DUPLICATE_DETECTION;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            },
    STRICT_DUPLICATE_DETECTION_DISABLE() {

                @Override
                public Boolean getValue() {
                    return Boolean.FALSE;
                }

                @Override
                public JsonParser.Feature getFeature() {
                    return JsonParser.Feature.STRICT_DUPLICATE_DETECTION;
                }

                @Override
                public void configureMapper(ObjectMapper mapper) {
                    mapper.configure(getFeature(), getValue());
                }

            }
}
