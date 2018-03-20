package com.mycompany.myapp.tools;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 * @author admin
 *
 */
@Component
public class BeanValidator {
 
    /** delimiters used in validator messages to split arguments */
    public static final String DEFAULT_ARG_DELIMITER = ",";
    public static final String MESSAGE_AND_ARGUMENTS_DELIMITER = "-";
 
 
    @Autowired private Validator validator;
 
    public boolean supports(Class clazz) {
        return true;
    }
 
    public boolean validate(Object target, Errors errors) {
 
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        writeConstraintViolationsToErrors(constraintViolations, errors);
        return (constraintViolations.isEmpty());
        
    }
 
    public boolean validate(Object target, Errors errors, Class... groups) {
 
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
        writeConstraintViolationsToErrors(constraintViolations, errors);
        return (constraintViolations.isEmpty());
 
    }
 
 
    private void writeConstraintViolationsToErrors(Set<ConstraintViolation<Object>> constraintViolations, Errors errors) {
 
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
 
            String propertyPath = constraintViolation.getPropertyPath().toString();
            
            String rawMessage = constraintViolation.getMessage();
            Object[] args = null;
            String resolvedMessage = null;
 
            String[] msgAndArgs = StringUtils.split(rawMessage,MESSAGE_AND_ARGUMENTS_DELIMITER);
            Assert.isTrue(msgAndArgs.length < 3, "Badly formed validor message. Single '-' or no delimiter in message is required. Message: " + rawMessage);
 
            if (msgAndArgs.length == 1) resolvedMessage = rawMessage;
            else {
                resolvedMessage = msgAndArgs[0];
                args = StringUtils.split(msgAndArgs[1], DEFAULT_ARG_DELIMITER);
            }
            
            if (propertyPath != null) {
                errors.rejectValue(propertyPath, resolvedMessage, args, resolvedMessage);
                continue;
            }
 
            errors.reject(resolvedMessage, args, resolvedMessage);
         }
 
    }
}
