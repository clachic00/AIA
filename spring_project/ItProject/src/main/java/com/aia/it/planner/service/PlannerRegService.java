package com.aia.it.planner.service;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DateFormatter;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.Planner;
import com.mysql.cj.ParseInfo;

@Service
public class PlannerRegService {
	
	private PlannerDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int plannerReg(Planner planner, HttpServletRequest request) {
		
		dao = sessionTemplate.getMapper(PlannerDaoInterface.class);
		
		int result = 0;
		
		List<LocalDate> dateList = new ArrayList<LocalDate>();
		
		result = dao.insertPlanner(planner);

		
		LocalDate startdate = LocalDate.parse(request.getParameter("startdate"));
		LocalDate enddate = LocalDate.parse(request.getParameter("enddate"));

		
		System.out.println(startdate);
		System.out.println(enddate);
		
		
		int betweenday = enddate.getDayOfYear()-startdate.getDayOfYear();
		
		
		
		dateList.add(startdate);
	
		for(int i=0;i<betweenday;i++) {
			
			
			
			startdate = startdate.plusDays(1);

			System.out.println(startdate);
			dateList.add(startdate);

		}
		

		

		System.out.println(dateList);
		
		
		
		
		
		
		return result;
	}

}
