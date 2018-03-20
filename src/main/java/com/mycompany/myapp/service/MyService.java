package com.mycompany.myapp.service;

import com.mycompany.myapp.model.GetHolidayDateIn;
import com.mycompany.myapp.model.GetHolidayDateOut;

/**
 * @author admin
 *
 */
public interface MyService {

	/**
	 * @param holidayDateIn
	 * @param isSoapCall
	 * @return
	 */
	public GetHolidayDateOut callGetHoliday(GetHolidayDateIn holidayDateIn, boolean isSoapCall);
}
