package com.aia.it.planner.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.Planner;

@Service
public class CalendarService {

	public List<LocalDate> getDateList(String startdate, String enddate) {

		List<LocalDate> dateList = new ArrayList<LocalDate>();

		LocalDate sdd = LocalDate.parse(startdate);
		LocalDate edd = LocalDate.parse(enddate);

		int betweenday = edd.getDayOfYear() - sdd.getDayOfYear();

		dateList.add(sdd);

		for (int i = 0; i < betweenday; i++) {

			sdd = sdd.plusDays(1);

			System.out.println(sdd);
			dateList.add(sdd);

		}
		System.out.println(dateList);
		return dateList;
	}

	private PlannerDaoInterface dao;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public int insertDate(Planner planner) {

		int result = 0;

		dao = sessionTemplate.getMapper(PlannerDaoInterface.class);

		result = dao.insertDate(planner);

		System.out.println("idx" + planner.getPidx());

		System.out.println(planner);

		System.out.println("idx" + planner.getPidx());

		return result;
	}
}
