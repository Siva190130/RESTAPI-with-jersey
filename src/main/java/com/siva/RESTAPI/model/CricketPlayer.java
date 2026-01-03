package com.siva.RESTAPI.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CricketPlayer {
    private int id;
    private String name;
    private String team;
    private String role;
    private int runs;
    
    
 // getters & setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	@Override
	public String toString() {
		return "CricketPlayer [id=" + id + ", name=" + name + ", team=" + team + ", role=" + role + ", runs=" + runs
				+ "]";
	}

	
    
    
}
