package com.hexaware.jdbidemo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.util.List;


@Path("/persons")
public class PersonRest {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Response fetchAll() {
    List<Person> personList = Person.listAllPerson();
    return Response.ok().entity(personList).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response findById(@PathParam("id") final int id) {
    final Person person = Person.findPersonById(id);
    if (person == null){
      return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Sorry, No such person found\"}").build();
    }
    return Response.ok().entity(person).build();
  }  

  @POST
  @Consumes(MediaType.APPLICATION_JSON) 
  public final Response insert(Person person) {
    int id = Person.insertIntoPersonTable(person);
    if (id < 0 ){
      return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Could not insert the person record\"}").build();
    }else{
      return Response.status(Response.Status.CREATED).ok().build();
    }

  }
}