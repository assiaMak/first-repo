package com.mycompany.myapp.webservice.holiday;

import com.holidaywebservice.holidayservice_v2.GetHolidayDate;
import com.holidaywebservice.holidayservice_v2.GetHolidayDateResponse;

/**
 * @author admin
 *
 */
public interface WebServiceHolidayProxy {


	/**
	 * @param wsGetHolidayDateIn
	 * @return
	 */
	public GetHolidayDateResponse callGetHolidayDateSoap(GetHolidayDate wsGetHolidayDateIn);

	/**
	 * @param wsGetHolidayDateIn
	 * @return
	 */
	public GetHolidayDateResponse callGetHolidayDateHttpPost(GetHolidayDate wsGetHolidayDateIn);
}
