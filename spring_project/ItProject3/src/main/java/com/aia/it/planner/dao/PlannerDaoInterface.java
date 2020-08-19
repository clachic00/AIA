package com.aia.it.planner.dao;

import java.util.List;

import com.aia.it.planner.model.Planner;
import com.aia.it.planner.model.PlannerJoinDaily;

public interface PlannerDaoInterface {

	public int insertPlanner(Planner planner);

	/*
	 * PlannerJoinDaily plannerJoinDaily(int uidx);
	 */
	
	public List<PlannerJoinDaily> selectDailyList(int uidx);

	/*
	 * public int deletePlannerByIdx(Planner planner); public int
	 * editPlanner(Planner planner); public int selectList();
	 */
	
}
