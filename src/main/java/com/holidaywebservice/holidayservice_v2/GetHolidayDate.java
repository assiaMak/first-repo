//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2018.03.03 � 09:22:55 PM WET 
//


package com.holidaywebservice.holidayservice_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countryCode" type="{http://www.holidaywebservice.com/HolidayService_v2/}Country"/>
 *         &lt;element name="holidayCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "countryCode",
    "holidayCode",
    "year"
})
@XmlRootElement(name = "GetHolidayDate")
public class GetHolidayDate {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Country countryCode;
    protected String holidayCode;
    protected int year;

    /**
     * Obtient la valeur de la propri�t� countryCode.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountryCode() {
        return countryCode;
    }

    /**
     * D�finit la valeur de la propri�t� countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountryCode(Country value) {
        this.countryCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� holidayCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolidayCode() {
        return holidayCode;
    }

    /**
     * D�finit la valeur de la propri�t� holidayCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolidayCode(String value) {
        this.holidayCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� year.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * D�finit la valeur de la propri�t� year.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
