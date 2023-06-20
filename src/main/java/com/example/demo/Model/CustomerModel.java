package com.example.demo.Model;

public class CustomerModel {
    private String customerName;
    private int CCCD;
    
    public CustomerModel(String customerName, int CCCD) {
        this.customerName = customerName;
        this.CCCD = CCCD;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCCCD() {
        return this.CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }
}
