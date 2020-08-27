package com.aia.it.daily.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.it.daily.model.DailyOrderEdit;
import com.aia.it.daily.service.DailyOrderEditService;

@RestController
@RequestMapping("/planner/dailyOrderEdit")
public class DailyOrderEditController {

	
	
	@Autowired
	DailyOrderEditService orderEditService;
	
	
	
	@PostMapping
	public int editDailyOrder(
				
				DailyOrderEdit daily
				

			){
		
		
		System.out.println(daily);
	
		
	System.out.println("컨트롤러까지 들어옴");
		
		
		return 	orderEditService.editOrder(daily);
	}
	
	
	
	
}
