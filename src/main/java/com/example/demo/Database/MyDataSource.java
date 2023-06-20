package com.example.demo.Database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.demo.Model.CustomerModel;
import com.example.demo.Model.OderModel;

@Component
public class MyDataSource {
    private CustomerModel[] customers_DB = {new CustomerModel("A1", 1), 
                                          new CustomerModel("A2", 2), 
                                          new CustomerModel("A3", 3),
                                          new CustomerModel("A4", 4),
                                          new CustomerModel("A5", 5)};
    private OderModel[] oders_DB = {   new OderModel(1, "Bike", 150.0, "A1", 1),
                                    new OderModel(2, "Shirt", 15.0, "A4", 4),
                                    new OderModel(3, "Coca", 1.5, "A2", 2),
                                    new OderModel(4, "Ball", 5.0, "A5", 5),
                                    new OderModel(5, "Flag", 2.0, "A3", 3),
                                    new OderModel(6, "Snack", 1.5, "A1", 1),
                                    new OderModel(7, "Kite", 5.0, "A2", 2),};
    private List<CustomerModel> customers = new ArrayList<CustomerModel>();
    
    private List<OderModel> oders = new ArrayList<OderModel>();

    public MyDataSource(){
        for(CustomerModel customer : customers_DB){
            customers.add(customer);
        }
        for(OderModel oder : oders_DB){
            oders.add(oder);
        }
    }
    public List<CustomerModel> getCustomers(){
        return this.customers;
    }

    public List<OderModel> getOders(){
        return this.oders;
    }

    public void addCustomer(String customerName, int CCCD){
        CustomerModel newCustomer = new CustomerModel(customerName, CCCD);
        this.customers.add(newCustomer);
    }
    public void addOder(String product, double price,String customerName, int CCCD){
        OderModel newOder = new OderModel(oders.get(oders.size() - 1).getOderId() + 1, product, price, customerName, CCCD);
        this.oders.add(newOder);
    }

    
}
