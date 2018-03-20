package com.mycompany.myapp.tools;

import org.dozer.CustomConverter;

import com.holidaywebservice.holidayservice_v2.Country;

public class CountryCustomConverter implements CustomConverter {

	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if (sourceFieldValue == null) 
            return null;
         
        if (sourceFieldValue instanceof Country) {
        	Country contry = (Country) sourceFieldValue;
            return contry.value();
 
        } else if (sourceFieldValue instanceof String) {
        	String contryName = (String) sourceFieldValue;
            return Country.fromValue(contryName);
        }
        
        return null;
	}
	
}
