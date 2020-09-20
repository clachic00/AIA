package com.aia.it.board.model;

public class LikeCountList {

	private int countAllLike;
	private int checkMyLike;
	
	public LikeCountList() {
	}

	public LikeCountList(int countAllLike, int checkMyLike) {
		super();
		this.countAllLike = countAllLike;
		this.checkMyLike = checkMyLike;
	}

	public int getCountAllLike() {
		return countAllLike;
	}

	public void setCountAllLike(int countAllLike) {
		this.countAllLike = countAllLike;
	}

	public int getCheckMyLike() {
		return checkMyLike;
	}

	public void setCheckMyLike(int checkMyLike) {
		this.checkMyLike = checkMyLike;
	}

	@Override
	public String toString() {
		return "LikeCountList [countAllLike=" + countAllLike + ", checkMyLike=" + checkMyLike + "]";
	}
	
	
	
	
	
	
}
