package com.mycompany.myapp.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MyAppProperties {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasenames(System.getProperty("myapp.config"), "validationErrors");
		bundleMessageSource.setDefaultEncoding("UTF-8");
		bundleMessageSource.setUseCodeAsDefaultMessage(true);
		
		return bundleMessageSource;
	}
	
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator()
	{
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}

}
