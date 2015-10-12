package org.glen.mccarthy.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("year")int year; 
	private @QueryParam("start")Integer start;
	private @QueryParam("size")Integer size;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
