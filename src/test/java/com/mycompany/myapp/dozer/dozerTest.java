package com.mycompany.myapp.dozer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.holidaywebservice.holidayservice_v2.GetHolidayDate;
import com.mycompany.myapp.model.GetHolidayDateIn;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dozerTestContext.xml"})
@WebAppConfiguration
public class dozerTest {

	@Autowired
	DozerBeanMapper dozerMapper;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@BeforeClass
	public static void initTest() {
        System.setProperty("validationErrors.config", "classpath:validationErrors");
    }
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void mappingTest() {

    	GetHolidayDateIn getHolidayDateIn = new GetHolidayDateIn();
    	getHolidayDateIn.setCodePaye(webApplicationContext.getMessage("test.countryCode", null, null));
    	getHolidayDateIn.setCodeVacance(webApplicationContext.getMessage("test.holidayCode", null, null));
    	getHolidayDateIn.setAnnee(webApplicationContext.getMessage("test.year", null, null));
    	 
    	GetHolidayDate getHolidayDateArgument = dozerMapper.map(getHolidayDateIn, GetHolidayDate.class);
        assertThat(getHolidayDateIn.getAnnee(),  is(Integer.toString(getHolidayDateArgument.getYear())));
        assertThat(getHolidayDateIn.getCodeVacance(), is(getHolidayDateArgument.getHolidayCode()));
        assertThat(getHolidayDateIn.getCodePaye(), is(getHolidayDateArgument.getCountryCode().value()));
        
        getHolidayDateIn = null;
        getHolidayDateIn = dozerMapper.map(getHolidayDateArgument, GetHolidayDateIn.class);
        assertThat(getHolidayDateArgument.getYear(),  is(Integer.parseInt(getHolidayDateIn.getAnnee())));
        assertThat(getHolidayDateArgument.getHolidayCode(), is(getHolidayDateIn.getCodeVacance()));
        assertThat(getHolidayDateArgument.getCountryCode().value(), is(getHolidayDateIn.getCodePaye()));
	}
}
