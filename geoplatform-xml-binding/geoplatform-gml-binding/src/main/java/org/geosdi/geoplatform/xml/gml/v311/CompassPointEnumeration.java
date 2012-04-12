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
package org.geosdi.geoplatform.xml.gml.v311;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for CompassPointEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CompassPointEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="NNE"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="ENE"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="ESE"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SSE"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="SSW"/>
 *     &lt;enumeration value="SW"/>
 *     &lt;enumeration value="WSW"/>
 *     &lt;enumeration value="W"/>
 *     &lt;enumeration value="WNW"/>
 *     &lt;enumeration value="NW"/>
 *     &lt;enumeration value="NNW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CompassPointEnumeration")
@XmlEnum
public enum CompassPointEnumeration {

    N,
    NNE,
    NE,
    ENE,
    E,
    ESE,
    SE,
    SSE,
    S,
    SSW,
    SW,
    WSW,
    W,
    WNW,
    NW,
    NNW;

    public String value() {
        return name();
    }

    public static CompassPointEnumeration fromValue(String v) {
        return valueOf(v);
    }
}