//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2018.03.03 � 09:22:55 PM WET 
//


package com.holidaywebservice.holidayservice_v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Country.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Country">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Canada"/>
 *     &lt;enumeration value="GreatBritain"/>
 *     &lt;enumeration value="IrelandNorthern"/>
 *     &lt;enumeration value="IrelandRepublicOf"/>
 *     &lt;enumeration value="Scotland"/>
 *     &lt;enumeration value="UnitedStates"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Country")
@XmlEnum
public enum Country {

    @XmlEnumValue("Canada")
    CANADA("Canada"),
    @XmlEnumValue("GreatBritain")
    GREAT_BRITAIN("GreatBritain"),
    @XmlEnumValue("IrelandNorthern")
    IRELAND_NORTHERN("IrelandNorthern"),
    @XmlEnumValue("IrelandRepublicOf")
    IRELAND_REPUBLIC_OF("IrelandRepublicOf"),
    @XmlEnumValue("Scotland")
    SCOTLAND("Scotland"),
    @XmlEnumValue("UnitedStates")
    UNITED_STATES("UnitedStates");
    private final String value;

    Country(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Country fromValue(String v) {
        for (Country c: Country.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
