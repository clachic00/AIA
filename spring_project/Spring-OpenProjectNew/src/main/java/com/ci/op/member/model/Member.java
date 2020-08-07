package com.ci.op.member.model;

import java.sql.Date;

public class Member {

	private int uidx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	private String uphone;
	private Date uregdate;
	
	
	
	public Member(int uidx, String uid, String upw, String uname, String uphoto, String uphone, Date uregdate) {
		super();
		this.uidx = uidx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.uphone = uphone;
		this.uregdate = uregdate;
	}
	
	public Member(String uid, String upw, String uname, String uphone) {
		this(0, uid, upw, uname, null, uphone, null);
	}

	

	public Member() {
	}
	
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
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public Date getUregdate() {
		return uregdate;
	}
	
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setUregdate(Date uregdate) {
		this.uregdate = uregdate;
	}
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate(){
		return new java.util.Date(uregdate.getTime());
	}
	
	// Member -> LoginInfo : 로그인 처리시 저장할 데이터
		public LoginInfo toLoginInfo() {
			return new LoginInfo(uid, uname, uphoto) ;
		}
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Member [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", uphone=" + uphone + ", uregdate=" + uregdate + "]";
	}










}



