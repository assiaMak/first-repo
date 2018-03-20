package com.mycompany.myapp.webservice.holiday;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class WsGetHolidayDateIn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String holidayCode;
	private String year;
	
	/**
	 * 
	 */
	public WsGetHolidayDateIn() {
		super();
	}

	/**
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 */
	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return
	 */
	public String getHolidayCode() {
		return holidayCode;
	}

	/**
	 * @param holidayCode
	 */
	public void setHolidayCode(final String holidayCode) {
		this.holidayCode = holidayCode;
	}

	/**
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(final String year) {
		this.year = year;
	}
	
}
