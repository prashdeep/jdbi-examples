package com.hexaware.jdbidemo;

import java.util.List;

public class ClientTest{
   public static void main(String args[]){
       //Person person = new Person(28, "Pradeep", 32);

       DBConnection db = new DBConnection();
       PersonDAO personDAO = db.getConnect().onDemand(PersonDAO.class);
       //personDAO.save(person);
       Person person = personDAO.find(12);
       System.out.println(person);
       personDAO.close();
    }
}