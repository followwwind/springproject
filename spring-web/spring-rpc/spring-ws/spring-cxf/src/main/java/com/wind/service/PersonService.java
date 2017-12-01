package com.wind.service;

import com.wind.entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author com.wind
 */
@Produces( {MediaType.APPLICATION_JSON })
public interface PersonService {

    @GET
    @Path("/person/{name}")
    Person getPerson(@PathParam("name") String name);

    @POST
    @Path("/persons")
    List<Person> getPersons();
}
