package com.myspace.discount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

public class Customer {
	
	private String type;
	private int year;
	private double discount;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int years) {
		this.year = years;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Customer [type=" + type + ", year=" + year + ", discount=" + discount + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
