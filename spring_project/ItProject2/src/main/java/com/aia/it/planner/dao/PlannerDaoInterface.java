package com.aia.it.planner.dao;

import com.aia.it.planner.model.Planner;

public interface PlannerDaoInterface {

	public int insertPlanner(Planner planner);
	public int deletePlannerByIdx(Planner planner);
	public int editPlanner(Planner planner);
	public int selectList(Planner planner);
}
