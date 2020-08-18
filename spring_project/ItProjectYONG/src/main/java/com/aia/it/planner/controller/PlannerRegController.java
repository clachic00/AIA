package com.aia.it.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.it.planner.model.Planner;
import com.aia.it.planner.service.PlannerRegService;

@Controller
@RequestMapping("/planner/plannerReg")
public class PlannerRegController {

	@Autowired
	PlannerRegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String getCalendarForm() {
		return "planner/calendarForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String plannerReg(@RequestParam("pidx")int pidx,
							 @RequestParam("date")String date,
							 Model model) {
		model.addAttribute("pidx",pidx);
		model.addAttribute("date",date);
		return "daily/dailyRegForm";
	}
}
