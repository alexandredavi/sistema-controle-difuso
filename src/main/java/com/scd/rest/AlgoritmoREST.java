package com.scd.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.scd.Algoritmo;
import com.scd.model.Variavel;

@Path("/algoritmoREST")
public class AlgoritmoREST {

	@POST
	@Consumes({"text/plain", "application/json"})
	public Response doPost(List<Variavel> variaveis) {
		
		Algoritmo algoritmo = new Algoritmo(variaveis);
		algoritmo.processar();
		
		return Response.ok().build();
	}
}