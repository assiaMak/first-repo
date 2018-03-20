package com.mycompany.myapp.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.myapp.Util.TestUtil;
import com.mycompany.myapp.model.GetHolidayDateIn;
import com.mycompany.myapp.model.GetHolidayDateOut;
import com.mycompany.myapp.service.MyService;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@ContextConfiguration(locations = {"classpath:controlerTestContext.xml", "classpath:applicationContext-web.xml"})
//@TestPropertySource (properties = { "validationErrors.config=file:/Users/admin/Documents/maven_workspace/my-webapp/src/main/resources/validationErrors" })
@WebAppConfiguration
public class MyRestControllerTest {
	
	@BeforeClass
	public static void initTest() {
        System.setProperty("validationErrors.config", "classpath:validationErrors");
    }

	private MockMvc mockMvc;
	 
    @Autowired
    private transient MyService myServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    protected Environment env;
    
    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(myServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void getHolidayDateTest() throws Exception {
    	GetHolidayDateIn getHolidayDateIn = new GetHolidayDateIn();
    	getHolidayDateIn.setCodePaye(webApplicationContext.getMessage("test.countryCode", null, null));
    	getHolidayDateIn.setCodeVacance(webApplicationContext.getMessage("test.holidayCode", null, null));
    	getHolidayDateIn.setAnnee(webApplicationContext.getMessage("test.year", null, null));
    	
    	GetHolidayDateOut getHolidayDateOut = new GetHolidayDateOut();
    	getHolidayDateOut.setGetHolidayDateResult("TestDateResult");
 
        when(myServiceMock.callGetHoliday(any(GetHolidayDateIn.class), Matchers.eq(true))).thenReturn(getHolidayDateOut);
 

        HashMap<String, String> prefix2Uri = new HashMap<String, String>();
        prefix2Uri.put("atom", "http://www.w3.org/2005/Atom");
        
        mockMvc.perform(post("/getHolidayDate")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(getHolidayDateIn))
        	)
        	.andExpect(status().isOk())
            .andExpect(content().contentType(TestUtil.APPLICATION_XML_UTF8));
//            .andExpect(hasXPath("//atom:feed/atom:entry[2]/atom:title/text()",
//                    equalTo(getHolidayDateOut.getGetHolidayDateResult())).withNamespaceContext(prefix2Uri).);
        
        ArgumentCaptor<GetHolidayDateIn> getHolidayDateInCaptor = ArgumentCaptor.forClass(GetHolidayDateIn.class);
        verify(myServiceMock, times(1)).callGetHoliday(getHolidayDateInCaptor.capture(), Matchers.eq(true));
        verifyNoMoreInteractions(myServiceMock);
 
        GetHolidayDateIn getHolidayDateArgument = getHolidayDateInCaptor.getValue();
        assertThat(getHolidayDateArgument.getAnnee(),  is(getHolidayDateIn.getAnnee()));
        assertThat(getHolidayDateArgument.getCodeVacance(), is(getHolidayDateIn.getCodeVacance()));
        assertThat(getHolidayDateArgument.getCodePaye(), is(getHolidayDateIn.getCodePaye()));
    }
    
    @Test
    public void getNameTest() throws Exception {
        String name = "nameTest";

        mockMvc.perform(get("/getName/{name}", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.TEXT_PLAIN_ISO_8859_1))
                .andExpect(content().string(name));
    }
}
