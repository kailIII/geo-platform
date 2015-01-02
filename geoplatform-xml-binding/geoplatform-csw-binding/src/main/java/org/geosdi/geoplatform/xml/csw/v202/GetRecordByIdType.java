/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 12:36:36 PM CEST 
//
package org.geosdi.geoplatform.xml.csw.v202;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 *
 * Convenience operation to retrieve default record representations
 * by identifier.
 * Id - object identifier (a URI) that provides a reference to a
 * catalogue item (or a result set if the catalogue supports
 * persistent result sets).
 * ElementSetName - one of "brief, "summary", or "full"
 *
 *
 * <p>Java class for GetRecordByIdType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetRecordByIdType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/cat/csw/2.0.2}RequestBaseType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.opengis.net/cat/csw/2.0.2}ElementSetName" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="outputFormat" type="{http://www.w3.org/2001/XMLSchema}string" default="application/xml" />
 *       &lt;attribute name="outputSchema" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(name = "GetRecordById")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRecordByIdType", propOrder = {
    "id",
    "elementSetName"
})
public class GetRecordByIdType
        extends RequestBaseType
        implements ToString {

    @XmlElement(name = "Id", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> id;
    @XmlElement(name = "ElementSetName", defaultValue = "summary")
    protected ElementSetNameType elementSetName;
    @XmlAttribute(name = "outputFormat")
    protected String outputFormat;
    @XmlAttribute(name = "outputSchema")
    @XmlSchemaType(name = "anyURI")
    protected String outputSchema;

    /**
     * Gets the value of the id property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the id property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getId() {
        if (id == null) {
            id = new ArrayList<String>();
        }
        return this.id;
    }

    public boolean isSetId() {
        return ((this.id != null) && (!this.id.isEmpty()));
    }

    public void unsetId() {
        this.id = null;
    }

    /**
     * Gets the value of the elementSetName property.
     *
     * @return
     * possible object is
     *     {@link ElementSetNameType }
     *
     */
    public ElementSetNameType getElementSetName() {
        return elementSetName;
    }

    /**
     * Sets the value of the elementSetName property.
     *
     * @param value
* allowed object is
     *     {@link ElementSetNameType }
     *
     */
    public void setElementSetName(ElementSetNameType value) {
        this.elementSetName = value;
    }

    public boolean isSetElementSetName() {
        return (this.elementSetName != null);
    }

    /**
     * Gets the value of the outputFormat property.
     *
     * @return
     * possible object is
     *     {@link String }
     *
     */
    public String getOutputFormat() {
        if (outputFormat == null) {
            return "application/xml";
        } else {
            return outputFormat;
        }
    }

    /**
     * Sets the value of the outputFormat property.
     *
     * @param value
* allowed object is
     *     {@link String }
     *
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    public boolean isSetOutputFormat() {
        return (this.outputFormat != null);
    }

    /**
     * Gets the value of the outputSchema property.
     *
     * @return
     * possible object is
     *     {@link String }
     *
     */
    public String getOutputSchema() {
        return outputSchema;
    }

    /**
     * Sets the value of the outputSchema property.
     *
     * @param value
* allowed object is
     *     {@link String }
     *
     */
    public void setOutputSchema(String value) {
        this.outputSchema = value;
    }

    public boolean isSetOutputSchema() {
        return (this.outputSchema != null);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            List<String> theId;
            theId = (this.isSetId() ? this.getId() : null);
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            ElementSetNameType theElementSetName;
            theElementSetName = this.getElementSetName();
            strategy.appendField(locator, this, "elementSetName", buffer,
                    theElementSetName);
        }
        {
            String theOutputFormat;
            theOutputFormat = this.getOutputFormat();
            strategy.appendField(locator, this, "outputFormat", buffer,
                    theOutputFormat);
        }
        {
            String theOutputSchema;
            theOutputSchema = this.getOutputSchema();
            strategy.appendField(locator, this, "outputSchema", buffer,
                    theOutputSchema);
        }
        return buffer;
    }

    public void setId(List<String> value) {
        this.id = null;
        List<String> draftl = this.getId();
        draftl.addAll(value);
    }
}
