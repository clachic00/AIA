package com.aia.it.daily.model;

public class Daily {
	
	private int didx;
	private String dloc;
	private String dloclon;
	private String dloclat;
	private String dmsg;
	private String dphoto;
	private String dtype;
	private int pidx;

	
	
	
	public Daily() {

	}

	public Daily(String dloc, String dloclon, String dloclat, String dmsg, String dtype, int pidx) {
		this(0,dloc,dloclon,dloclat,dmsg,null,dtype,pidx);
	}

	public Daily(int didx, String dloc, String dloclon, String dloclat, String dmsg, String dphoto, String dtype, int pidx) {
		this.didx = didx;
		this.dloc = dloc;
		this.dloclon = dloclon;
		this.dloclat = dloclat;
		this.dmsg = dmsg;
		this.dphoto = dphoto;
		this.dtype = dtype;
		this.pidx = pidx;
	}

	public int getDidx() {
		return didx;
	}

	public void setDidx(int didx) {
		this.didx = didx;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public String getDloclon() {
		return dloclon;
	}

	public void setDloclon(String dloclon) {
		this.dloclon = dloclon;
	}

	public String getDloclat() {
		return dloclat;
	}

	public void setDloclat(String dloclat) {
		this.dloclat = dloclat;
	}

	public String getDmsg() {
		return dmsg;
	}

	public void setDmsg(String dmsg) {
		this.dmsg = dmsg;
	}

	public String getDphoto() {
		return dphoto;
	}

	public void setDphoto(String dphoto) {
		this.dphoto = dphoto;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	@Override
	public String toString() {
		return "Daily [didx=" + didx + ", dloc=" + dloc + ", dloclon=" + dloclon + ", dloclat=" + dloclat + ", dmsg="
				+ dmsg + ", dphoto=" + dphoto + ", dtype=" + dtype + ", pidx=" + pidx + "]";
	}

	
	
	
	
	

}
