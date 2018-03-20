package com.mycompany.myapp.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dozer.CustomConverter;

/**
 * @author admin
 *
 */
public class EnumCustomConverter implements CustomConverter {

//	public Object convert(Object existingDestinationFieldValue,
//			Object sourceFieldValue, Class<?> destinationClass,
//			Class<?> sourceClass) {
//		if (sourceFieldValue == null) 
//            return null;
//         
//        if (sourceClass.isEnum()) {
//        	return getValue(sourceClass, destinationClass, sourceFieldValue);
// 
//        } else if (destinationClass.isEnum()) {
//        	return getEnum(sourceClass, destinationClass, sourceFieldValue);
//        }
//        
//        return null;
//	}
	
	
	/* (non-Javadoc)
	 * @see org.dozer.CustomConverter#convert(java.lang.Object, java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if (sourceFieldValue == null) {
			return null;
		}
         
        if (org.springframework.util.ClassUtils.isPrimitiveOrWrapper(sourceClass) || sourceFieldValue instanceof String) {
        	return getEnum(sourceClass, destinationClass, sourceFieldValue);
        } else if (org.springframework.util.ClassUtils.isPrimitiveOrWrapper(destinationClass) || String.class.equals(destinationClass)) {
        	return getValue(sourceClass, destinationClass, sourceFieldValue);
        }
        
        return null;
	}
	
	private Object getValue(Class<?> sourceClass, Class<?> destinationClass, Object source) {
		Object simpleObject = null;
		
		try {
			Method getValueMethod = sourceClass.getMethod("value");
			simpleObject = getValueMethod.invoke(source);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return simpleObject;
	}
	
	private Object getEnum(Class<?> sourceClass, Class<?> destinationClass, Object source) {
		Object enumeration = null;
		
		try {
			Method getValueMethod = destinationClass.getMethod("fromValue", sourceClass);
			enumeration = getValueMethod.invoke(sourceClass, source);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return enumeration;
		
	}
}
