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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCountriesAvailableResult" type="{http://www.holidaywebservice.com/HolidayService_v2/}ArrayOfCountryCode" minOccurs="0"/>
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
    "getCountriesAvailableResult"
})
@XmlRootElement(name = "GetCountriesAvailableResponse")
public class GetCountriesAvailableResponse {

    @XmlElement(name = "GetCountriesAvailableResult")
    protected ArrayOfCountryCode getCountriesAvailableResult;

    /**
     * Obtient la valeur de la propriété getCountriesAvailableResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCountryCode }
     *     
     */
    public ArrayOfCountryCode getGetCountriesAvailableResult() {
        return getCountriesAvailableResult;
    }

    /**
     * Définit la valeur de la propriété getCountriesAvailableResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCountryCode }
     *     
     */
    public void setGetCountriesAvailableResult(ArrayOfCountryCode value) {
        this.getCountriesAvailableResult = value;
    }

}
