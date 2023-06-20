package com.example.demo.BeanCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;



public class MyBook implements ApplicationContextAware, BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    
    private String bookName;

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public MyBook() {
        System.out.println("Constructor of myBook Called");
    }

    public MyBook(String name){
        this.bookName = name;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Set Bean Factory Method Called");
        System.out.println("My Bean is Singleton = " + beanFactory.isSingleton("myBook"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext Awared Method Called");
        for(String s : applicationContext.getBeanDefinitionNames()){
            System.out.println("Bean: " + s);
        }
        System.out.println(this.getBookName());
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Set Bean Name Called");
        System.out.println("Set Bean Name: " + beanName);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy Method Called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.bookName = "Hello World";
        System.out.println("After Properties Set: " + this.getBookName());
    }

    public void customInit()throws Exception{
        System.out.println("My Custom Init Method!!");
    }

    public void customDestroy() throws Exception{
        System.out.println("My Custom Destroy Method!!");
    }

}
