package br.udesc.ceavi.sistemamoveldecoletadedados.model;

import java.util.Date;

public class Research {

	private int id;
	private Date oldDate;
	private String oldBrand;
	private String oldSpecification;
	private double oldPrice;
	private Date newDate;
	private String newBrand;
	private String newSpecification;
	private double newPrice;
	private Item item;
	private Source source;
	private Control control;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOldDate() {
		return oldDate;
	}
	public void setOldDate(Date oldDate) {
		this.oldDate = oldDate;
	}
	public String getOldBrand() {
		return oldBrand;
	}
	public void setOldBrand(String oldBrand) {
		this.oldBrand = oldBrand;
	}
	public String getOldSpecification() {
		return oldSpecification;
	}
	public void setOldSpecification(String oldSpecification) {
		this.oldSpecification = oldSpecification;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Date getNewDate() {
		return newDate;
	}
	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
	public String getNewBrand() {
		return newBrand;
	}
	public void setNewBrand(String newBrand) {
		this.newBrand = newBrand;
	}
	public String getNewSpecification() {
		return newSpecification;
	}
	public void setNewSpecification(String newSpecification) {
		this.newSpecification = newSpecification;
	}
	public double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Control getControl() {
		return control;
	}
	public void setControl(Control control) {
		this.control = control;
	}
	
}
