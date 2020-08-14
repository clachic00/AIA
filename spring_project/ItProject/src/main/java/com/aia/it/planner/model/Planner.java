package com.aia.it.planner.model;

public class Planner {
	private int pidx;
	private String ptitle;
	private int uidx;
	
	
	
	
	
	public Planner() {
		
	}

	public Planner(int pidx, String ptitle, String pdate, int uidx) {
		this.pidx = pidx;
		this.ptitle = ptitle;
		this.uidx = uidx;
	}


	
	
	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
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

	@Override
	public String toString() {
		return "Planner [pidx=" + pidx + ", ptitle=" + ptitle + ", uidx=" + uidx + "]";
	}
	
	
	
	
	
}
