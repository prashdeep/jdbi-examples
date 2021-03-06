package com.hexaware.jdbidemo;

import java.util.*;
import java.text.ParseException;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    
    private int a;
    private int b;

    public Calculator(){

    }

    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int sum(String a, String b) throws ParseException{
        logger.error("Entered sum method with params: a: "+a+" b: "+b );
        int a1 = Integer.parseInt(a);

        int b1 = Integer.parseInt(b);
        logger.error("Returning from the sum method:" );
        return a1 + b1;
    }

    public List<String> returnList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        return list;
    }

    public int sub(int a , int b){
        return a - b;
    }

    public int mult(int a, int b){
        return a * b;
    }

    public int divide(int a , int b){
        return a / b;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.a = a;
    }

    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }

    public int hashCode(){
        return 34;
    }

    public boolean equals(Object obj){
     Calculator cal = (Calculator) obj;
     if (this.a == cal.getA() && this.b == cal.getB()){
         return true;
     }
     return false;
    }
}