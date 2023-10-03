package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class CMAM {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="Make")
	private String make;
	@Column(name="Model")
	private String model;
	@Column(name="Year")
	private String year;
	
	public CMAM() {
	super();
	}
	public CMAM(int id, String make, String model, String year) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public CMAM(String make, String model, String year){
	super();
	this.make = make;
	this.model = model;
	this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
