package com.aia.it.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.it.planner.model.Planner;
import com.aia.it.planner.service.CalendarService;
import com.aia.it.planner.service.PlannerRegService;

@Controller
@RequestMapping("/calendar/calendar")
public class CalendarController {

	@Autowired
	CalendarService calendarService;

	@RequestMapping(method = RequestMethod.GET)
	public String getCalendarForm() {
		return "planner/calendarForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String plannerReg(Planner planner, Model model) {

		model.addAttribute("result", calendarService.insertDate(planner));
		model.addAttribute("planner", planner);
		model.addAttribute("dateList", calendarService.getDateList(planner.getPstartdate(), planner.getPenddate()));

		return "planner/plannerRegForm";
	}
}
