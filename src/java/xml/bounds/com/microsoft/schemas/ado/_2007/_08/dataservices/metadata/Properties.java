//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.07.17 a las 10:32:32 AM CEST 
//


package xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC10YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC1MONTH;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC1YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC20YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC2YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC30YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC30YEARDISPLAY;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC3MONTH;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC3YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC5YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC6MONTH;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.BC7YEAR;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.Id;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.NEWDATE;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}Id"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}NEW_DATE"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_1MONTH"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_3MONTH"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_6MONTH"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_1YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_2YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_3YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_5YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_7YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_10YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_20YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_30YEAR"/>
 *         &lt;element ref="{http://schemas.microsoft.com/ado/2007/08/dataservices}BC_30YEARDISPLAY"/>
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
    "id",
    "newdate",
    "bc1MONTH",
    "bc3MONTH",
    "bc6MONTH",
    "bc1YEAR",
    "bc2YEAR",
    "bc3YEAR",
    "bc5YEAR",
    "bc7YEAR",
    "bc10YEAR",
    "bc20YEAR",
    "bc30YEAR",
    "bc30YEARDISPLAY"
})
@XmlRootElement(name = "properties")
public class Properties {

    @XmlElement(name = "Id", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected Id id;
    @XmlElement(name = "NEW_DATE", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected NEWDATE newdate;
    @XmlElement(name = "BC_1MONTH", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC1MONTH bc1MONTH;
    @XmlElement(name = "BC_3MONTH", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC3MONTH bc3MONTH;
    @XmlElement(name = "BC_6MONTH", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC6MONTH bc6MONTH;
    @XmlElement(name = "BC_1YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC1YEAR bc1YEAR;
    @XmlElement(name = "BC_2YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC2YEAR bc2YEAR;
    @XmlElement(name = "BC_3YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC3YEAR bc3YEAR;
    @XmlElement(name = "BC_5YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC5YEAR bc5YEAR;
    @XmlElement(name = "BC_7YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC7YEAR bc7YEAR;
    @XmlElement(name = "BC_10YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC10YEAR bc10YEAR;
    @XmlElement(name = "BC_20YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC20YEAR bc20YEAR;
    @XmlElement(name = "BC_30YEAR", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC30YEAR bc30YEAR;
    @XmlElement(name = "BC_30YEARDISPLAY", namespace = "http://schemas.microsoft.com/ado/2007/08/dataservices", required = true)
    protected BC30YEARDISPLAY bc30YEARDISPLAY;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setId(Id value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad newdate.
     * 
     * @return
     *     possible object is
     *     {@link NEWDATE }
     *     
     */
    public NEWDATE getNEWDATE() {
        return newdate;
    }

    /**
     * Define el valor de la propiedad newdate.
     * 
     * @param value
     *     allowed object is
     *     {@link NEWDATE }
     *     
     */
    public void setNEWDATE(NEWDATE value) {
        this.newdate = value;
    }

    /**
     * Obtiene el valor de la propiedad bc1MONTH.
     * 
     * @return
     *     possible object is
     *     {@link BC1MONTH }
     *     
     */
    public BC1MONTH getBC1MONTH() {
        return bc1MONTH;
    }

    /**
     * Define el valor de la propiedad bc1MONTH.
     * 
     * @param value
     *     allowed object is
     *     {@link BC1MONTH }
     *     
     */
    public void setBC1MONTH(BC1MONTH value) {
        this.bc1MONTH = value;
    }

    /**
     * Obtiene el valor de la propiedad bc3MONTH.
     * 
     * @return
     *     possible object is
     *     {@link BC3MONTH }
     *     
     */
    public BC3MONTH getBC3MONTH() {
        return bc3MONTH;
    }

    /**
     * Define el valor de la propiedad bc3MONTH.
     * 
     * @param value
     *     allowed object is
     *     {@link BC3MONTH }
     *     
     */
    public void setBC3MONTH(BC3MONTH value) {
        this.bc3MONTH = value;
    }

    /**
     * Obtiene el valor de la propiedad bc6MONTH.
     * 
     * @return
     *     possible object is
     *     {@link BC6MONTH }
     *     
     */
    public BC6MONTH getBC6MONTH() {
        return bc6MONTH;
    }

    /**
     * Define el valor de la propiedad bc6MONTH.
     * 
     * @param value
     *     allowed object is
     *     {@link BC6MONTH }
     *     
     */
    public void setBC6MONTH(BC6MONTH value) {
        this.bc6MONTH = value;
    }

    /**
     * Obtiene el valor de la propiedad bc1YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC1YEAR }
     *     
     */
    public BC1YEAR getBC1YEAR() {
        return bc1YEAR;
    }

    /**
     * Define el valor de la propiedad bc1YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC1YEAR }
     *     
     */
    public void setBC1YEAR(BC1YEAR value) {
        this.bc1YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc2YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC2YEAR }
     *     
     */
    public BC2YEAR getBC2YEAR() {
        return bc2YEAR;
    }

    /**
     * Define el valor de la propiedad bc2YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC2YEAR }
     *     
     */
    public void setBC2YEAR(BC2YEAR value) {
        this.bc2YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc3YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC3YEAR }
     *     
     */
    public BC3YEAR getBC3YEAR() {
        return bc3YEAR;
    }

    /**
     * Define el valor de la propiedad bc3YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC3YEAR }
     *     
     */
    public void setBC3YEAR(BC3YEAR value) {
        this.bc3YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc5YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC5YEAR }
     *     
     */
    public BC5YEAR getBC5YEAR() {
        return bc5YEAR;
    }

    /**
     * Define el valor de la propiedad bc5YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC5YEAR }
     *     
     */
    public void setBC5YEAR(BC5YEAR value) {
        this.bc5YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc7YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC7YEAR }
     *     
     */
    public BC7YEAR getBC7YEAR() {
        return bc7YEAR;
    }

    /**
     * Define el valor de la propiedad bc7YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC7YEAR }
     *     
     */
    public void setBC7YEAR(BC7YEAR value) {
        this.bc7YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc10YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC10YEAR }
     *     
     */
    public BC10YEAR getBC10YEAR() {
        return bc10YEAR;
    }

    /**
     * Define el valor de la propiedad bc10YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC10YEAR }
     *     
     */
    public void setBC10YEAR(BC10YEAR value) {
        this.bc10YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc20YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC20YEAR }
     *     
     */
    public BC20YEAR getBC20YEAR() {
        return bc20YEAR;
    }

    /**
     * Define el valor de la propiedad bc20YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC20YEAR }
     *     
     */
    public void setBC20YEAR(BC20YEAR value) {
        this.bc20YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc30YEAR.
     * 
     * @return
     *     possible object is
     *     {@link BC30YEAR }
     *     
     */
    public BC30YEAR getBC30YEAR() {
        return bc30YEAR;
    }

    /**
     * Define el valor de la propiedad bc30YEAR.
     * 
     * @param value
     *     allowed object is
     *     {@link BC30YEAR }
     *     
     */
    public void setBC30YEAR(BC30YEAR value) {
        this.bc30YEAR = value;
    }

    /**
     * Obtiene el valor de la propiedad bc30YEARDISPLAY.
     * 
     * @return
     *     possible object is
     *     {@link BC30YEARDISPLAY }
     *     
     */
    public BC30YEARDISPLAY getBC30YEARDISPLAY() {
        return bc30YEARDISPLAY;
    }

    /**
     * Define el valor de la propiedad bc30YEARDISPLAY.
     * 
     * @param value
     *     allowed object is
     *     {@link BC30YEARDISPLAY }
     *     
     */
    public void setBC30YEARDISPLAY(BC30YEARDISPLAY value) {
        this.bc30YEARDISPLAY = value;
    }

}
