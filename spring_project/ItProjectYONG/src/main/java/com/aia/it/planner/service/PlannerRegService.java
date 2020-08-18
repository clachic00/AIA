package com.aia.it.planner.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.Planner;

@Service
public class PlannerRegService {
	
	private PlannerDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;



	public int insertDate(Planner planner) {

		int result = 0;
		
		dao = sessionTemplate.getMapper(PlannerDaoInterface.class);
		
		result = dao.insertDate(planner);
		
		System.out.println("idx"+planner.getPidx());
		
		System.out.println(planner);
		
		System.out.println("idx"+planner.getPidx());
		
		
		return result;
	}

}
