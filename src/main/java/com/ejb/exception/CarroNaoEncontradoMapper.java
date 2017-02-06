package com.ejb.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CarroNaoEncontradoMapper implements ExceptionMapper<CarroNaoEncontradoException>{

	public Response toResponse(CarroNaoEncontradoException exception) {
		 return Response.status(Response.Status.NOT_FOUND).build();
	}

}
