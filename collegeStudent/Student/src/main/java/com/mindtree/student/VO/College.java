package com.mindtree.student.VO;

public class College {

	private long id;
	private String name;
	private int totalnoofstudent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getTotalnoofstudent() {
		return totalnoofstudent;
	}
	public void setTotalnoofstudent(int totalnoofstudent) {
		this.totalnoofstudent = totalnoofstudent;
	}
	
	public College(long id, String name, int totalnoofstudent) {
		super();
		this.id = id;
		this.name = name;
		this.totalnoofstudent = totalnoofstudent;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
}
