package com.mycompany.myapp.serviceImpl;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holidaywebservice.holidayservice_v2.GetHolidayDate;
import com.holidaywebservice.holidayservice_v2.GetHolidayDateResponse;
import com.mycompany.myapp.model.GetHolidayDateIn;
import com.mycompany.myapp.model.GetHolidayDateOut;
import com.mycompany.myapp.service.MyService;
import com.mycompany.myapp.tools.CountryCustomConverter;
import com.mycompany.myapp.webservice.holiday.WebServiceHolidayProxy;

/**
 * @author admin
 *
 */
@Service
public class MyServiceImpl implements MyService{

	@Autowired
	transient WebServiceHolidayProxy webServiceHolidayProxy;
	
	/* (non-Javadoc)
	 * @see com.mycompany.myapp.service.MyService#callGetHoliday(com.mycompany.myapp.model.GetHolidayDateIn)
	 */
	public GetHolidayDateOut callGetHoliday(GetHolidayDateIn holidayDateIn, boolean isSoapCall){
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder builder = new BeanMappingBuilder() {
		    @Override
		    protected void configure() {
		        mapping(GetHolidayDateIn.class, GetHolidayDate.class)
		          .fields("countryCode", "countryCode", FieldsMappingOptions.customConverter(CountryCustomConverter.class));
		    }
		};
		
		mapper.addMapping(builder);
		
		GetHolidayDate wsGetHolidayDateIn = mapper.map(holidayDateIn, GetHolidayDate.class);
		GetHolidayDateResponse wsGetHolidayDateOut;
		if(isSoapCall){
			wsGetHolidayDateOut = webServiceHolidayProxy.callGetHolidayDateSoap(wsGetHolidayDateIn);
		}
		else {
			wsGetHolidayDateOut = webServiceHolidayProxy.callGetHolidayDateHttpPost(wsGetHolidayDateIn);
		}
		if(null != wsGetHolidayDateOut){
			return mapper.map(wsGetHolidayDateOut, GetHolidayDateOut.class);
		}
		return null;
	}
}
