package com.mycompany.myapp.model;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class GetHolidayDateOut implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String getHolidayDateResult;

	/**
	 * 
	 */
	public GetHolidayDateOut() {
		super();
	}

	/**
	 * @return
	 */
	public String getGetHolidayDateResult() {
		return getHolidayDateResult;
	}

	/**
	 * @param getHolidayDateResult
	 */
	public void setGetHolidayDateResult(final String getHolidayDateResult) {
		this.getHolidayDateResult = getHolidayDateResult;
	}
	
}
