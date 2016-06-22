package com.scd.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scd.Algoritmo;
import com.scd.model.Variavel;

@Path("/algoritmoREST")
public class AlgoritmoREST {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doPost(List<Variavel> variaveis) {
		
		Algoritmo algoritmo = new Algoritmo(variaveis);
		List<Variavel> variaveisReorno = algoritmo.processar();
		
		return Response.ok().entity(variaveisReorno).build();
	}
}