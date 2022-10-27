package fr.api.rattrapage.controller;



import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

	 @GetMapping("/time")
	   	public long giveTime() {
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 return timestamp.getTime();
	   		
	   		
	   	}
}
