package br.udesc.ceavi.sistemamoveldecoletadedados.model;

import java.util.ArrayList;
import java.util.List;

public class Researcher {

	private int id;
	private String name;
	private String user;
	private String password;
	private List<Source> sources;
	
	public Researcher(){
		this.sources = new ArrayList<Source>();
	}
	
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}
	
}
