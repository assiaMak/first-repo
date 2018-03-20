//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.03.03 à 09:22:55 PM WET 
//


package com.holidaywebservice.holidayservice_v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour HolidayDateType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="HolidayDateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Observed"/>
 *     &lt;enumeration value="Actual"/>
 *     &lt;enumeration value="ObservedActual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HolidayDateType")
@XmlEnum
public enum HolidayDateType {

    @XmlEnumValue("Observed")
    OBSERVED("Observed"),
    @XmlEnumValue("Actual")
    ACTUAL("Actual"),
    @XmlEnumValue("ObservedActual")
    OBSERVED_ACTUAL("ObservedActual");
    private final String value;

    HolidayDateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HolidayDateType fromValue(String v) {
        for (HolidayDateType c: HolidayDateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
