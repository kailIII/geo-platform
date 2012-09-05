//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 11:58:17 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v321;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * gml:AbstractGeneralParameterValuePropertyType is a  property type for inline association roles to a parameter value or group of parameter values, always containing the values.
 * 
 * <p>Java class for AbstractGeneralParameterValuePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractGeneralParameterValuePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}AbstractGeneralParameterValue"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractGeneralParameterValuePropertyType", propOrder = {
    "abstractGeneralParameterValue"
})
public class AbstractGeneralParameterValuePropertyType
    implements ToString
{

    @XmlElementRef(name = "AbstractGeneralParameterValue", namespace = "http://www.opengis.net/gml/3.2", type = JAXBElement.class)
    protected JAXBElement<? extends AbstractGeneralParameterValueType> abstractGeneralParameterValue;

    /**
     * Gets the value of the abstractGeneralParameterValue property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterValueUpperCase }
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ParameterValueGroupType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractGeneralParameterValueType> getAbstractGeneralParameterValue() {
        return abstractGeneralParameterValue;
    }

    /**
     * Sets the value of the abstractGeneralParameterValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterValueUpperCase }
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ParameterValueGroupType }{@code >}
     *     
     */
    public void setAbstractGeneralParameterValue(JAXBElement<? extends AbstractGeneralParameterValueType> value) {
        this.abstractGeneralParameterValue = value;
    }

    public boolean isSetAbstractGeneralParameterValue() {
        return (this.abstractGeneralParameterValue!= null);
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
            JAXBElement<? extends AbstractGeneralParameterValueType> theAbstractGeneralParameterValue;
            theAbstractGeneralParameterValue = this.getAbstractGeneralParameterValue();
            strategy.appendField(locator, this, "abstractGeneralParameterValue", buffer, theAbstractGeneralParameterValue);
        }
        return buffer;
    }

}