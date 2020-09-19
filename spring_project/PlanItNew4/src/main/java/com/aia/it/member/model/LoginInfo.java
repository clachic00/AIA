package com.aia.it.member.model;

public class LoginInfo {
	
	private int uidx;
	
	private String uid;
	private String uname; 
	private String uphoto;
	private String uphonenum;
	private char ukakao;
	
	
	public LoginInfo() {
	}
	
	public LoginInfo(String uid, String uname, String uphoto) {
		this.uid = uid;
		this.uname = uname;
		this.uphoto = uphoto;
	}
	
	public LoginInfo(int uidx, String uid, String uname, String uphoto) {
		this.uidx= uidx;
		this.uid = uid;
		this.uname = uname;
		this.uphoto = uphoto;
	}
	
	public LoginInfo(String uid, String uname, String uphonenum, String uphoto, char ukakao) {
		this.uid = uid;
		this.uname = uname;
		this.uphonenum = uphonenum; 
		this.uphoto = uphoto;
		this.ukakao = ukakao;
	}
	
	public String getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getUphoto() {
		return uphoto;
	}
	

	@Override
	public String toString() {
		return "LoginInfo [uidx=" + uidx + ", uid=" + uid + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}

	public int getUidx() {
		return uidx;
	}

	public void setUidx(int uidx) {
		this.uidx = uidx;
	}

	public String getUphonenum() {
		return uphonenum;
	}

	public char getUkakao() {
		return ukakao;
	}


	
	
}
