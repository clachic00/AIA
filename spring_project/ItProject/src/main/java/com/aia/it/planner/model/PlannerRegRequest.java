package com.aia.it.planner.model;

public class PlannerRegRequest {

	private String ptitle;
	private int uidx;
	
	
	
	public PlannerRegRequest(String ptitle, int uidx) {
		this.ptitle = ptitle;
		this.uidx = uidx;
	}



	public String getPtitle() {
		return ptitle;
	}



	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}



	public int getUidx() {
		return uidx;
	}



	public void setUidx(int uidx) {
		this.uidx = uidx;
	}



	public PlannerRegRequest() {
	}



	@Override
	public String toString() {
		return "PlannerRegRequest [ptitle=" + ptitle + ", uidx=" + uidx + "]";
	}
	
	
	
	
	
	
}
