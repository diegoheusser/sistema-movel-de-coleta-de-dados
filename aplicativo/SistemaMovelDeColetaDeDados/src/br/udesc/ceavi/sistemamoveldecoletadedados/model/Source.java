package br.udesc.ceavi.sistemamoveldecoletadedados.model;

import java.util.ArrayList;
import java.util.List;

public class Source {

	private int id;
	private String description;
	private String localization;
	private List<Researcher> researchers;
	
	public Source(){
		researchers = new ArrayList<Researcher>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public List<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}
	
}
