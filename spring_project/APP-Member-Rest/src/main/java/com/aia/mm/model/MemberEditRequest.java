package com.aia.mm.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberEditRequest {

	private int uidx;
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile photo;
	private String oldFile;
	private String uphone;
	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getOldFile() {
		return oldFile;
	}
	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}
	
	
	public Member toMember() {
		return new Member(uidx, uid, upw, uname, oldFile.length()>0?oldFile:null, uphone, null );
	}
	
	
	@Override
	public String toString() {
		return "MemberEditRequest [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo="
				+ photo + ", oldFile=" + oldFile + ", uphone=" + uphone + "]";
	}
	
	
	
	
	
	
	
	
}
