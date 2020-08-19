package com.aia.it.daily.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.it.daily.service.DailyListService;

@Controller
@RequestMapping("/planner/dailyList")
public class DailyListController {

	
	
		
		@Autowired
		private DailyListService listService;
		
		@RequestMapping(method = RequestMethod.POST)
		public String getBoardList(
				int uidx,
					Model model,
					HttpServletRequest request
					) {
			
//			int idx = Integer.parseInt(uidx);
			System.out.println(uidx);
			model.addAttribute("listView", listService.getView(request, uidx));
			
			return "planner/plannerRegForm";
			
		}
			
	
	
	
	
	
	
}
