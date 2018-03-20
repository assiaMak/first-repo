package com.mycompany.myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.model.GetHolidayDateIn;
import com.mycompany.myapp.model.GetHolidayDateOut;
import com.mycompany.myapp.service.MyService;


/**
 * @author admin
 *
 */
@RestController
public class MyRestController {
	
	@Autowired
	private transient MyService myService;
	
	/**
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	/**
	 * @param reqest
	 */
	@RequestMapping(path = "/getHolidayDate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public GetHolidayDateOut getHolidayDate(@Valid @RequestBody GetHolidayDateIn reqest){
		System.out.println(reqest.getCodeVacance() + "\t" + reqest.getCodePaye());
		
		return myService.callGetHoliday(reqest, true);
	}
	
	@RequestMapping(path = "/getName/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getName(@PathVariable String name){
		System.out.println("name:"+name);
		return name;
	}
	
}
