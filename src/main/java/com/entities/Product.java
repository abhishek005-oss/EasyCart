package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String pname;
    private String pPhoto;
    private String pdesc;
    private int pPrice;
    private int pDiscount;
    private int pQuantity;
    @ManyToOne
    private Category category;

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Product{" +
                "pdesc='" + pdesc + '\'' +
                '}';
    }

    public Product(Category category) {
        super();
        this.category = category;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPdesc() {
        return pdesc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Product(String pname, String pPhoto, int pPrice, int pDiscount, int pQuantity) {
        super();
        this.pname = pname;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
    }
    public int getPriceAfterApplyingDiscount(){
        int d=(int)((this .getpDiscount()/100.0)*this.getpPrice());
        return this.getpPrice()-d;
    }
}
