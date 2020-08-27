package com.aia.it.daily.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.it.daily.model.DailyOrderEditForm;
import com.aia.it.daily.service.DailyOrderEditService;

@RestController
@RequestMapping("/planner/dailyOrderEdit")
public class DailyOrderEditController {

	
	
	@Autowired
	DailyOrderEditService orderEditService;
	
	
	
	
	@PostMapping("/{didx}")
	public int editDailyOrder(
				DailyOrderEditForm dailyOrderEdit,
				@PathVariable("didx") int didx

			){
		
		System.out.println(dailyOrderEdit);
		
	System.out.println("컨트롤러까지 들어옴");
		
		
		return 	orderEditService.editOrder(dailyOrderEdit);
	}
	
	
	
	
}
