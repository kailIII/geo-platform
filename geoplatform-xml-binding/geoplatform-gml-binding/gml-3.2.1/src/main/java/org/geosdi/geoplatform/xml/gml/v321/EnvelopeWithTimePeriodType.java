//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 11:58:17 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v321;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for EnvelopeWithTimePeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnvelopeWithTimePeriodType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}EnvelopeType">
 *       &lt;sequence>
 *         &lt;element name="beginPosition" type="{http://www.opengis.net/gml/3.2}TimePositionType"/>
 *         &lt;element name="endPosition" type="{http://www.opengis.net/gml/3.2}TimePositionType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="frame" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="#ISO-8601" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvelopeWithTimePeriodType", propOrder = {
    "beginPosition",
    "endPosition"
})
public class EnvelopeWithTimePeriodType
    extends EnvelopeType
    implements ToString
{

    @XmlElement(required = true)
    protected TimePositionType beginPosition;
    @XmlElement(required = true)
    protected TimePositionType endPosition;
    @XmlAttribute(name = "frame")
    @XmlSchemaType(name = "anyURI")
    protected String frame;

    /**
     * Gets the value of the beginPosition property.
     * 
     * @return
     *     possible object is
     *     {@link TimePositionType }
     *     
     */
    public TimePositionType getBeginPosition() {
        return beginPosition;
    }

    /**
     * Sets the value of the beginPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePositionType }
     *     
     */
    public void setBeginPosition(TimePositionType value) {
        this.beginPosition = value;
    }

    public boolean isSetBeginPosition() {
        return (this.beginPosition!= null);
    }

    /**
     * Gets the value of the endPosition property.
     * 
     * @return
     *     possible object is
     *     {@link TimePositionType }
     *     
     */
    public TimePositionType getEndPosition() {
        return endPosition;
    }

    /**
     * Sets the value of the endPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePositionType }
     *     
     */
    public void setEndPosition(TimePositionType value) {
        this.endPosition = value;
    }

    public boolean isSetEndPosition() {
        return (this.endPosition!= null);
    }

    /**
     * Gets the value of the frame property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrame() {
        if (frame == null) {
            return "#ISO-8601";
        } else {
            return frame;
        }
    }

    /**
     * Sets the value of the frame property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrame(String value) {
        this.frame = value;
    }

    public boolean isSetFrame() {
        return (this.frame!= null);
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
            TimePositionType theBeginPosition;
            theBeginPosition = this.getBeginPosition();
            strategy.appendField(locator, this, "beginPosition", buffer, theBeginPosition);
        }
        {
            TimePositionType theEndPosition;
            theEndPosition = this.getEndPosition();
            strategy.appendField(locator, this, "endPosition", buffer, theEndPosition);
        }
        {
            String theFrame;
            theFrame = this.getFrame();
            strategy.appendField(locator, this, "frame", buffer, theFrame);
        }
        return buffer;
    }

}