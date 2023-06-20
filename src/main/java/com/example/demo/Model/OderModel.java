package com.example.demo.Model;

public class OderModel {
    private int oderId;
    private String product;
    private String customerName;
    private int customerCCCD;
    private double price;

    public OderModel(int oderId, String product, double price, String customerName, int customerCCCD) {
        this.oderId = oderId;
        this.product = product;
        this.price = price;
        this.customerName = customerName;
        this.customerCCCD = customerCCCD;
    }

    public OderModel(String product, double price, String customerName, int customerCCCD) {
        this.product = product;
        this.price = price;
        this.customerName = customerName;
        this.customerCCCD = customerCCCD;
    }

    public int getOderId() {
        return this.oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCustomerCCCD() {
        return this.customerCCCD;
    }

    public void setCustomerCCCD(int customerCCCD) {
        this.customerCCCD = customerCCCD;
    }
}