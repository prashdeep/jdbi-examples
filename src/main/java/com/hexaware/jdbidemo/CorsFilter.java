package com.hexaware.jdbidemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * This class is a filter which adds the necessary headers so that
 * cross-origin requests are accepted.
 */
class CORSFilter implements ContainerResponseFilter {

  /**
   * This method adds the necessary headers so that
   * cross-origin requests are accepted.
   * @param request the request object
   * @param response the response object
   */
  public void filter(final ContainerRequestContext request,
      final ContainerResponseContext response) {
    response.getHeaders().add("Access-Control-Allow-Origin", "*");
    response.getHeaders().add("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization");
    response.getHeaders().add("Access-Control-Allow-Credentials", "true");
    response.getHeaders().add("Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD");
  }
}