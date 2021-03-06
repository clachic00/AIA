package com.aia.it.daily.model;

import org.springframework.web.multipart.MultipartFile;

public class DailyEditRequest {

	private int didx;
	private String dloc;
	private String dloclon;
	private String dloclat;
	private String daddr;
	private String dmsg;
	private MultipartFile dphoto;
	private String oldFile;
	private String dtype;
	private String ddate;
	private int ddidx;
	private int pidx;
	
	public Daily toDaily() {
		return new Daily(didx,dloc,dloclon,dloclat,daddr,dmsg,oldFile.length()>0?oldFile:null, dtype, ddate, ddidx, pidx);
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

	public String getDaddr() {
		return daddr;
	}

	public void setDaddr(String daddr) {
		this.daddr = daddr;
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

	public String getOldFile() {
		return oldFile;
	}

	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public int getDdidx() {
		return ddidx;
	}

	public void setDdidx(int ddidx) {
		this.ddidx = ddidx;
	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	@Override
	public String toString() {
		return "DailyEditRequest [didx=" + didx + ", dloc=" + dloc + ", dloclon=" + dloclon + ", dloclat=" + dloclat
				+ ", daddr=" + daddr + ", dmsg=" + dmsg + ", dphoto=" + dphoto + ", oldFile=" + oldFile + ", dtype="
				+ dtype + ", ddate=" + ddate + ", ddidx=" + ddidx + ", pidx=" + pidx + "]";
	}
	
	
	
}
