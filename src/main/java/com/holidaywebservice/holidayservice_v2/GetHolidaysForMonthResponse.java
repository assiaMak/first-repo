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
 *         &lt;element name="GetHolidaysForMonthResult" type="{http://www.holidaywebservice.com/HolidayService_v2/}ArrayOfHoliday" minOccurs="0"/>
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
    "getHolidaysForMonthResult"
})
@XmlRootElement(name = "GetHolidaysForMonthResponse")
public class GetHolidaysForMonthResponse {

    @XmlElement(name = "GetHolidaysForMonthResult")
    protected ArrayOfHoliday getHolidaysForMonthResult;

    /**
     * Obtient la valeur de la propri�t� getHolidaysForMonthResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHoliday }
     *     
     */
    public ArrayOfHoliday getGetHolidaysForMonthResult() {
        return getHolidaysForMonthResult;
    }

    /**
     * D�finit la valeur de la propri�t� getHolidaysForMonthResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHoliday }
     *     
     */
    public void setGetHolidaysForMonthResult(ArrayOfHoliday value) {
        this.getHolidaysForMonthResult = value;
    }

}
