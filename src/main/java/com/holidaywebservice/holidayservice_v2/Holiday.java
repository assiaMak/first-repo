//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.03.03 à 09:22:55 PM WET 
//


package com.holidaywebservice.holidayservice_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Holiday complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Holiday">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Country" type="{http://www.holidaywebservice.com/HolidayService_v2/}Country"/>
 *         &lt;element name="HolidayCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Descriptor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HolidayType" type="{http://www.holidaywebservice.com/HolidayService_v2/}HolidayType"/>
 *         &lt;element name="DateType" type="{http://www.holidaywebservice.com/HolidayService_v2/}HolidayDateType"/>
 *         &lt;element name="BankHoliday" type="{http://www.holidaywebservice.com/HolidayService_v2/}BankHoliday"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RelatedHolidayCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicableRegions" type="{http://www.holidaywebservice.com/HolidayService_v2/}ArrayOfRegionCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Holiday", propOrder = {
    "country",
    "holidayCode",
    "descriptor",
    "holidayType",
    "dateType",
    "bankHoliday",
    "date",
    "relatedHolidayCode",
    "applicableRegions"
})
public class Holiday {

    @XmlElement(name = "Country", required = true)
    @XmlSchemaType(name = "string")
    protected Country country;
    @XmlElement(name = "HolidayCode")
    protected String holidayCode;
    @XmlElement(name = "Descriptor")
    protected String descriptor;
    @XmlElement(name = "HolidayType", required = true)
    @XmlSchemaType(name = "string")
    protected HolidayType holidayType;
    @XmlElement(name = "DateType", required = true)
    @XmlSchemaType(name = "string")
    protected HolidayDateType dateType;
    @XmlElement(name = "BankHoliday", required = true)
    @XmlSchemaType(name = "string")
    protected BankHoliday bankHoliday;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "RelatedHolidayCode")
    protected String relatedHolidayCode;
    @XmlElement(name = "ApplicableRegions")
    protected ArrayOfRegionCode applicableRegions;

    /**
     * Obtient la valeur de la propriété country.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Définit la valeur de la propriété country.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountry(Country value) {
        this.country = value;
    }

    /**
     * Obtient la valeur de la propriété holidayCode.
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
     * Définit la valeur de la propriété holidayCode.
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
     * Obtient la valeur de la propriété descriptor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Définit la valeur de la propriété descriptor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptor(String value) {
        this.descriptor = value;
    }

    /**
     * Obtient la valeur de la propriété holidayType.
     * 
     * @return
     *     possible object is
     *     {@link HolidayType }
     *     
     */
    public HolidayType getHolidayType() {
        return holidayType;
    }

    /**
     * Définit la valeur de la propriété holidayType.
     * 
     * @param value
     *     allowed object is
     *     {@link HolidayType }
     *     
     */
    public void setHolidayType(HolidayType value) {
        this.holidayType = value;
    }

    /**
     * Obtient la valeur de la propriété dateType.
     * 
     * @return
     *     possible object is
     *     {@link HolidayDateType }
     *     
     */
    public HolidayDateType getDateType() {
        return dateType;
    }

    /**
     * Définit la valeur de la propriété dateType.
     * 
     * @param value
     *     allowed object is
     *     {@link HolidayDateType }
     *     
     */
    public void setDateType(HolidayDateType value) {
        this.dateType = value;
    }

    /**
     * Obtient la valeur de la propriété bankHoliday.
     * 
     * @return
     *     possible object is
     *     {@link BankHoliday }
     *     
     */
    public BankHoliday getBankHoliday() {
        return bankHoliday;
    }

    /**
     * Définit la valeur de la propriété bankHoliday.
     * 
     * @param value
     *     allowed object is
     *     {@link BankHoliday }
     *     
     */
    public void setBankHoliday(BankHoliday value) {
        this.bankHoliday = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété relatedHolidayCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedHolidayCode() {
        return relatedHolidayCode;
    }

    /**
     * Définit la valeur de la propriété relatedHolidayCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedHolidayCode(String value) {
        this.relatedHolidayCode = value;
    }

    /**
     * Obtient la valeur de la propriété applicableRegions.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRegionCode }
     *     
     */
    public ArrayOfRegionCode getApplicableRegions() {
        return applicableRegions;
    }

    /**
     * Définit la valeur de la propriété applicableRegions.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRegionCode }
     *     
     */
    public void setApplicableRegions(ArrayOfRegionCode value) {
        this.applicableRegions = value;
    }

}
