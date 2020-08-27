package com.aia.it.daily.model;

public class DailyOrderEditForm {

	private String didx;
	private String ddate;
	private String ddidx;
	
	
	
	public DailyOrderEditForm() {
	}
	
	
	public DailyOrderEditForm(String didx, String ddate, String ddidx) {
		this.didx = didx;
		this.ddate = ddate;
		this.ddidx = ddidx;
	}


	public String getDidx() {
		return didx;
	}
	public void setDidx(String didx) {
		this.didx = didx;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getDdidx() {
		return ddidx;
	}
	public void setDdidx(String ddidx) {
		this.ddidx = ddidx;
	}


	@Override
	public String toString() {
		return "DailyEditOrder [didx=" + didx + ", ddate=" + ddate + ", ddidx=" + ddidx + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
