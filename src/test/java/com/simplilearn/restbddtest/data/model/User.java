package com.simplilearn.restbddtest.data.model;

public class User {

	public final String name;
	public final String job;

	public User(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return "PostData [name=" + name + ", job=" + job + "]";
	}
}
