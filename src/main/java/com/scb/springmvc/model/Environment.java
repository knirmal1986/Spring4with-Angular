package com.scb.springmvc.model;

public class Environment {

	private long id;
	
	private String url;
	
	private String schema;
	
	private String startDate;
	
	private String endDate;
	
	private String projectName;
	
	private String env;	
	
	
	
	public Environment(long id, String url, String schema, String startDate,
			String endDate, String projectName, String env) {
		super();
		this.id = id;
		this.url = url;
		this.schema = schema;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectName = projectName;
		this.env = env;
	}



	public Environment(){
		id=0;
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getSchema() {
		return schema;
	}



	public void setSchema(String schema) {
		this.schema = schema;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getEnv() {
		return env;
	}



	public void setEnv(String env) {
		this.env = env;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Environment))
			return false;
		Environment other = (Environment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", address=" + address
				+ ", email=" + email + "]";
	}*/
	

	
}
