package com.hexaware.jdbidemo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/persons")
public class PersonRest {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Person> fetchAll() {
    List<Person> personList = Person.listAllPerson();
    return personList;
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Person findById(@PathParam("id") final int id) {
    final Person person = Person.findPersonById(id);
    return person;
  }  

  @POST
  @Consumes(MediaType.APPLICATION_JSON) 
  public final void insert(Person person) {
    Person.insertIntoPersonTable(person);
  }
}