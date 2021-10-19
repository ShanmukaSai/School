package com.springtask.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	private static final Logger log = LoggerFactory
			.getLogger(Controller.class);
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	//get all students
	@RequestMapping("/students")
	public Object getAllStudentInfo() throws Exception {
		String url="http://localhost:9090/students";
		String response=null;
		try {
		 response= 
			restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
		log.info(response.toString());
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return response;
		}
	
	@RequestMapping("/student/{studentid}")
	public Object getAStudentInfo(@PathVariable String studentid) throws Exception {
		String url="http://localhost:9090/student/"+studentid;
		String response=null;
		try {
		 response= 
			restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
		log.info(response.toString());
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return response;
		}
	}


