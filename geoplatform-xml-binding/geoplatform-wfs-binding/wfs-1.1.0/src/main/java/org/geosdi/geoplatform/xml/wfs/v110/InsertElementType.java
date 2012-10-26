//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.26 at 03:16:42 PM CEST 
//


package org.geosdi.geoplatform.xml.wfs.v110;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.gml.v311.AbstractFeatureCollectionType;
import org.geosdi.geoplatform.xml.gml.v311.AbstractFeatureType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * 
 *             An Insert element may contain a feature collection or one 
 *             or more feature instances to be inserted into the 
 *             repository.
 *          
 * 
 * <p>Java class for InsertElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsertElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}_Feature" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="idgen" type="{http://www.opengis.net/wfs}IdentifierGenerationOptionType" default="GenerateNew" />
 *       &lt;attribute name="handle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inputFormat" type="{http://www.w3.org/2001/XMLSchema}string" default="text/xml; subtype=gml/3.1.1" />
 *       &lt;attribute name="srsName" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertElementType", propOrder = {
    "feature"
})
public class InsertElementType implements ToString
{

    @XmlElementRef(name = "_Feature", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected List<JAXBElement<?>> feature;
    @XmlAttribute(name = "idgen")
    protected IdentifierGenerationOptionType idgen;
    @XmlAttribute(name = "handle")
    protected String handle;
    @XmlAttribute(name = "inputFormat")
    protected String inputFormat;
    @XmlAttribute(name = "srsName")
    @XmlSchemaType(name = "anyURI")
    protected String srsName;

    /**
     * Gets the value of the feature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getFeature() {
        if (feature == null) {
            feature = new ArrayList<JAXBElement<?>>();
        }
        return this.feature;
    }

    /**
     * Gets the value of the idgen property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierGenerationOptionType }
     *     
     */
    public IdentifierGenerationOptionType getIdgen() {
        if (idgen == null) {
            return IdentifierGenerationOptionType.GENERATE_NEW;
        } else {
            return idgen;
        }
    }

    /**
     * Sets the value of the idgen property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierGenerationOptionType }
     *     
     */
    public void setIdgen(IdentifierGenerationOptionType value) {
        this.idgen = value;
    }

    /**
     * Gets the value of the handle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Sets the value of the handle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandle(String value) {
        this.handle = value;
    }

    /**
     * Gets the value of the inputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputFormat() {
        if (inputFormat == null) {
            return "text/xml; subtype=gml/3.1.1";
        } else {
            return inputFormat;
        }
    }

    /**
     * Sets the value of the inputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputFormat(String value) {
        this.inputFormat = value;
    }

    /**
     * Gets the value of the srsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrsName() {
        return srsName;
    }

    /**
     * Sets the value of the srsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrsName(String value) {
        this.srsName = value;
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
        {
            List<JAXBElement<?>> theFeature;
            theFeature = (((this.feature!= null)&&(!this.feature.isEmpty()))?this.getFeature():null);
            strategy.appendField(locator, this, "feature", buffer, theFeature);
        }
        {
            IdentifierGenerationOptionType theIdgen;
            theIdgen = this.getIdgen();
            strategy.appendField(locator, this, "idgen", buffer, theIdgen);
        }
        {
            String theHandle;
            theHandle = this.getHandle();
            strategy.appendField(locator, this, "handle", buffer, theHandle);
        }
        {
            String theInputFormat;
            theInputFormat = this.getInputFormat();
            strategy.appendField(locator, this, "inputFormat", buffer, theInputFormat);
        }
        {
            String theSrsName;
            theSrsName = this.getSrsName();
            strategy.appendField(locator, this, "srsName", buffer, theSrsName);
        }
        return buffer;
    }

    public void setFeature(List<JAXBElement<?>> value) {
        this.feature = null;
        List<JAXBElement<?>> draftl = this.getFeature();
        draftl.addAll(value);
    }

}