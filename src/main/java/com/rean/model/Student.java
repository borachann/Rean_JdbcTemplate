package com.rean.model;

import java.math.BigDecimal;

public class Student {
	private int stuid;
	private String lvlyear;
	private String stuname;
	private BigDecimal score;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getLvlyear() {
		return lvlyear;
	}
	public void setLvlyear(String lvlyear) {
		this.lvlyear = lvlyear;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	
}
