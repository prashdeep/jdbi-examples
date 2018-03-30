package com.hexaware.jdbidemo;

import java.util.List;


public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(){}
  

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }    

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public static PersonDAO dao(){
       DBConnection db = new DBConnection();
       PersonDAO personDAO = db.getConnect().onDemand(PersonDAO.class);
       return personDAO;
    }

    public static void insertIntoPersonTable(Person person){
        System.out.println("Inserting into Person table "+person);
        dao().save(person);
    }

    public static Person findPersonById(int personId){
        System.out.println("Find by Person Id "+personId);
        return dao().find(personId);
    }

    public static List<Person> listAllPerson(){
        System.out.println("Listing all person ");
        return dao().list();
    }

    @Override
    public String toString(){
        return "Person [ id: "+id+" name: "+name+" age: "+age+" ]";
    }
    
}

