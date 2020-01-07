package com.qa.data;

public class Data {
	
	String name;
	String job;
	
	public Data(String name,String job)
	{
		this.name=name;
		this.job=job;
	}
	public String getJob() 
	{
		return job;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setJob(String job) 
	{
		this.job = job;
	}
}
