package com.maocq.restful.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class NoFound implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {	
		String message = exception.getMessage();
		return Response.status(Response.Status.NOT_FOUND).entity(new Message(message)).build();
	}

}
