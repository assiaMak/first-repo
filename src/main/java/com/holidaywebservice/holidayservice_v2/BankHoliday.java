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
 * <p>Classe Java pour BankHoliday.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="BankHoliday">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Recognized"/>
 *     &lt;enumeration value="NotRecognized"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BankHoliday")
@XmlEnum
public enum BankHoliday {

    @XmlEnumValue("Recognized")
    RECOGNIZED("Recognized"),
    @XmlEnumValue("NotRecognized")
    NOT_RECOGNIZED("NotRecognized");
    private final String value;

    BankHoliday(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BankHoliday fromValue(String v) {
        for (BankHoliday c: BankHoliday.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
