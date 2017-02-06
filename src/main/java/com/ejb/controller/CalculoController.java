package com.ejb.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ejb.model.vo.CarroVO;
import com.ejb.service.CarroService;

@Path("/calculo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculoController {

	@EJB
	private CarroService service;

	@GET
	public Response find(@QueryParam("marca") String marca,
			@QueryParam("modelo") String modelo,
			@QueryParam("placa") String placa) {
		CarroVO carroVO = service.calcularTotais(marca, modelo, placa);
		if (carroVO != null) {
			return Response.ok(carroVO).build();
		}
		return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
    }

	

}
