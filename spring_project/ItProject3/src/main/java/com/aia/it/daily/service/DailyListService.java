package com.aia.it.daily.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.daily.model.DailyList;
import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.PlannerJoinDaily;

@Service
public class DailyListService {
	
	private PlannerDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public DailyList getView(
			HttpServletRequest request, 
			int uidx) {
		
		//view로 전달할 결과 데이터
		DailyList listView = null;
		
		dao=sessionTemplate.getMapper(PlannerDaoInterface.class);
		
		List<PlannerJoinDaily> dailyList = null;
	
		dailyList = dao.selectDailyList(uidx);

		listView = new DailyList(dailyList);
		System.out.println("나는 데일리의 리스트뷰!"+listView);
	
		
		return listView;
	}
}
