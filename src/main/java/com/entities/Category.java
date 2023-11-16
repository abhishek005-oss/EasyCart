package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int categoryid;
private String Cdescription;
private String CTitle;
@OneToMany(mappedBy="category")
private List<Product> product=new ArrayList<>();
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public String getCdescription() {
	return Cdescription;
}
public void setCdescription(String cdescription) {
	Cdescription = cdescription;
}
public String getCTitle() {
	return CTitle;
}
public void setCTitle(String cTitle) {
	CTitle = cTitle;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
@Override
public String toString() {
	return "Category [categoryid=" + categoryid + ", Cdescription=" + Cdescription + ", CTitle=" + CTitle + ", product="
			+ product + "]";
}
public Category() {
	super();
	// TODO Auto-generated constructor stub
}
public Category(int categoryid, String cdescription, String cTitle, List<Product> product) {
	super();
	this.categoryid = categoryid;
	Cdescription = cdescription;
	CTitle = cTitle;
	this.product = product;
}

}
