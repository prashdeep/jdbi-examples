package com.hexaware.jdbidemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;



@ApplicationPath("/")
public class Application extends ResourceConfig {

  public Application() {
    packages("com.hexaware.jdbidemo");
    register(new CORSFilter());
    // Enable Tracing support.
    property(ServerProperties.TRACING, "ALL");
  }
}