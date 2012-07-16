//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.16 at 12:48:05 PM CEST 
//


package org.geosdi.geoplatform.xml.wps.v100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Full description of a process. 
 * 
 * <p>Java class for ProcessDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}ProcessBriefType">
 *       &lt;sequence>
 *         &lt;element name="DataInputs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Input" type="{http://www.opengis.net/wps/1.0.0}InputDescriptionType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProcessOutputs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDescriptionType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="storeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="statusSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDescriptionType", propOrder = {
    "dataInputs",
    "processOutputs"
})
public class ProcessDescriptionType
    extends ProcessBriefType
    implements ToString
{

    @XmlElement(name = "DataInputs", namespace = "")
    protected ProcessDescriptionType.DataInputs dataInputs;
    @XmlElement(name = "ProcessOutputs", namespace = "", required = true)
    protected ProcessDescriptionType.ProcessOutputs processOutputs;
    @XmlAttribute(name = "storeSupported")
    protected Boolean storeSupported;
    @XmlAttribute(name = "statusSupported")
    protected Boolean statusSupported;

    /**
     * Gets the value of the dataInputs property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessDescriptionType.DataInputs }
     *     
     */
    public ProcessDescriptionType.DataInputs getDataInputs() {
        return dataInputs;
    }

    /**
     * Sets the value of the dataInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessDescriptionType.DataInputs }
     *     
     */
    public void setDataInputs(ProcessDescriptionType.DataInputs value) {
        this.dataInputs = value;
    }

    public boolean isSetDataInputs() {
        return (this.dataInputs!= null);
    }

    /**
     * Gets the value of the processOutputs property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessDescriptionType.ProcessOutputs }
     *     
     */
    public ProcessDescriptionType.ProcessOutputs getProcessOutputs() {
        return processOutputs;
    }

    /**
     * Sets the value of the processOutputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessDescriptionType.ProcessOutputs }
     *     
     */
    public void setProcessOutputs(ProcessDescriptionType.ProcessOutputs value) {
        this.processOutputs = value;
    }

    public boolean isSetProcessOutputs() {
        return (this.processOutputs!= null);
    }

    /**
     * Gets the value of the storeSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStoreSupported() {
        if (storeSupported == null) {
            return false;
        } else {
            return storeSupported;
        }
    }

    /**
     * Sets the value of the storeSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStoreSupported(boolean value) {
        this.storeSupported = value;
    }

    public boolean isSetStoreSupported() {
        return (this.storeSupported!= null);
    }

    public void unsetStoreSupported() {
        this.storeSupported = null;
    }

    /**
     * Gets the value of the statusSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStatusSupported() {
        if (statusSupported == null) {
            return false;
        } else {
            return statusSupported;
        }
    }

    /**
     * Sets the value of the statusSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatusSupported(boolean value) {
        this.statusSupported = value;
    }

    public boolean isSetStatusSupported() {
        return (this.statusSupported!= null);
    }

    public void unsetStatusSupported() {
        this.statusSupported = null;
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
            ProcessDescriptionType.DataInputs theDataInputs;
            theDataInputs = this.getDataInputs();
            strategy.appendField(locator, this, "dataInputs", buffer, theDataInputs);
        }
        {
            ProcessDescriptionType.ProcessOutputs theProcessOutputs;
            theProcessOutputs = this.getProcessOutputs();
            strategy.appendField(locator, this, "processOutputs", buffer, theProcessOutputs);
        }
        {
            boolean theStoreSupported;
            theStoreSupported = (this.isSetStoreSupported()?this.isStoreSupported():false);
            strategy.appendField(locator, this, "storeSupported", buffer, theStoreSupported);
        }
        {
            boolean theStatusSupported;
            theStatusSupported = (this.isSetStatusSupported()?this.isStatusSupported():false);
            strategy.appendField(locator, this, "statusSupported", buffer, theStatusSupported);
        }
        return buffer;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Input" type="{http://www.opengis.net/wps/1.0.0}InputDescriptionType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "input"
    })
    public static class DataInputs
        implements ToString
    {

        @XmlElement(name = "Input", namespace = "", required = true)
        protected List<InputDescriptionType> input;

        /**
         * Gets the value of the input property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the input property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InputDescriptionType }
         * 
         * 
         */
        public List<InputDescriptionType> getInput() {
            if (input == null) {
                input = new ArrayList<InputDescriptionType>();
            }
            return this.input;
        }

        public boolean isSetInput() {
            return ((this.input!= null)&&(!this.input.isEmpty()));
        }

        public void unsetInput() {
            this.input = null;
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
                List<InputDescriptionType> theInput;
                theInput = (this.isSetInput()?this.getInput():null);
                strategy.appendField(locator, this, "input", buffer, theInput);
            }
            return buffer;
        }

        public void setInput(List<InputDescriptionType> value) {
            this.input = null;
            List<InputDescriptionType> draftl = this.getInput();
            draftl.addAll(value);
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDescriptionType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "output"
    })
    public static class ProcessOutputs
        implements ToString
    {

        @XmlElement(name = "Output", namespace = "", required = true)
        protected List<OutputDescriptionType> output;

        /**
         * Gets the value of the output property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the output property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputDescriptionType }
         * 
         * 
         */
        public List<OutputDescriptionType> getOutput() {
            if (output == null) {
                output = new ArrayList<OutputDescriptionType>();
            }
            return this.output;
        }

        public boolean isSetOutput() {
            return ((this.output!= null)&&(!this.output.isEmpty()));
        }

        public void unsetOutput() {
            this.output = null;
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
                List<OutputDescriptionType> theOutput;
                theOutput = (this.isSetOutput()?this.getOutput():null);
                strategy.appendField(locator, this, "output", buffer, theOutput);
            }
            return buffer;
        }

        public void setOutput(List<OutputDescriptionType> value) {
            this.output = null;
            List<OutputDescriptionType> draftl = this.getOutput();
            draftl.addAll(value);
        }

    }

}
