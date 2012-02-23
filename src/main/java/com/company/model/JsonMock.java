package com.company.model;

import javax.persistence.Id;

public class JsonMock {
	
	@Id Long id;
	String json;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
