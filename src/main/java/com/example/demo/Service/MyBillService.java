package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.Database.MyDataSource;
import com.example.demo.Model.CustomerModel;
import com.example.demo.Model.OderModel;

@Service("myBillService")
public class MyBillService {
    private MyDataSource myDataSource;

    public MyBillService(){
        myDataSource = new MyDataSource();
    }

    public String getBillByID(int oderId){
        String result = "NOT FOUND";
        List<OderModel> oders = myDataSource.getOders();
        for(int i = 0; i < oders.size(); i++){
            if(oders.get(i).getOderId() == oderId){
                OderModel oder = oders.get(i);
                String product = oder.getProduct();
                double price = oder.getPrice();
                String customerName = oder.getCustomerName();
                result = "Bill " + oderId + ": {" + product + ", " + price + ", " 
                + customerName + "}" ;
            }
        }
        return result;
    }
    public String CreateBill(String product, double price,String customerName, int CCCD){
        if(ValidCustomer(CCCD).equals(customerName)){
            myDataSource.addOder(product, price, customerName, CCCD);
            return "Created Oder";
        } else if(ValidCustomer(CCCD).equals("NOT_FOUND")){
            myDataSource.addCustomer(customerName, CCCD);
            myDataSource.addOder(product, price, customerName, CCCD);
            return "Create Customer and Oder";
        } 
        return "Fail To Create";
        
        
    }
    public String ValidCustomer(int CCCD){
        List<CustomerModel> customers = myDataSource.getCustomers();
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getCCCD() == CCCD){
                return customers.get(i).getCustomerName();
            }
        }
        return "NOT_FOUND";
    }

}
