package com.aia.it.daily.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class DailyRegRequest {
	
	private String dloc;
	private String dloclon;
	private String dloclat;
	private String dmsg;
	private MultipartFile dphoto;
	private String dtype;
	private Date ddate;
	private int ddidx;
	
	private int pidx;
	
	public Daily toDaily() {
		return new Daily(dloc,dloclon,dloclat,dmsg,dtype, ddate, ddidx, pidx);
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

	public MultipartFile getDphoto() {
		return dphoto;
	}

	public void setDphoto(MultipartFile dphoto) {
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
		return "DailyRegRequest [dloc=" + dloc + ", dloclon=" + dloclon + ", dloclat=" + dloclat + ", dmsg=" + dmsg
				+ ", dphoto=" + dphoto + ", dtype=" + dtype + ", pidx=" + pidx + "]";
	}

	
	
	
	
	
	
	}
