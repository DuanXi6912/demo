package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.BeanCycle.MyBook;
import com.example.demo.Service.MyBillService;

// Cách 1 cho Auto Component Scan
@SpringBootApplication
// // Cách 2 
// @Configuration
// @ComponentScan
// @EnableAutoConfiguration
public class SpringBootApplications {

    public static void printNameList(List<String> beans){
        for(int i = 0; i < beans.size(); i++){
            System.out.println(beans.get(i));
        }
    }

    public static void printGetBillByID(MyBillService myBillService, int oderId){
        System.out.println(myBillService.getBillByID(oderId));
    }

    public static void printCreateBill(MyBillService myBillService, String product, double price, String customerName, int CCCD){
        String result = myBillService.CreateBill(product, price, customerName, CCCD);
        System.out.println(result);
    }

    
    public static void main(String[] args) {


        SpringApplication.run(SpringBootApplications.class, args);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringBootApplications.class);
        // Get my-Bean-Create-List in IoC container
        System.out.println("My Bean Created: ");
        List<String> myBeanCreateList = new ArrayList<>();
        String[] allBeans = context.getBeanDefinitionNames();
        for(String s : allBeans){
            if(s.startsWith("my")){
                myBeanCreateList.add(s);
            }
        } 
        printNameList(myBeanCreateList);
        // Get Bean in IoC container and use 
        System.out.println("Get Bill: ");
        MyBillService myBill = (MyBillService) context.getBean(MyBillService.class);
        
        // Get Bill By OderID
        printGetBillByID(myBill, 1);

        //
        System.out.println("Try Test Case For Create Bill: ");
        // Name = A4, CCCD = 7 => Created Customer and Oder
        System.out.println("Case 1) Name = A4, CCCD = 7: ");
        printCreateBill(myBill, "Game", 3.0, "A4", 7);
        // Name = A5, CCCD = 7 => Fail To Create
        System.out.println("Case 2) Name = A5, CCCD = 7: ");
        printCreateBill(myBill, "Game", 3.0, "A5", 7);
        // Name = A1, CCCD = 1 => Create Oder
        System.out.println("Case 3) Name = A1, CCCD = 1: ");
        printCreateBill(myBill, "Game", 3.0, "A1", 1);
        context.close();
    
        ConfigurableApplicationContext newContext 
        = new ClassPathXmlApplicationContext("appconfig.xml");
        MyBook myBook = (MyBook) newContext.getBean("myBook");
        
        System.out.println("Get Name of The Book: " + myBook.getBookName());
        // Destrucsion 
        newContext.close();

         
        
    }
}
