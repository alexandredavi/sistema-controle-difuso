package com.scd.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.scd.model.Variavel;

@Path("/algoritmoREST")
public class AlgoritmoREST {

	@POST
	@Consumes({"text/plain", "application/json"})
	public Response doPost(List<Variavel> variaveis) {
		variaveis.stream().forEach(i -> System.out.println(i.getDescricao()));
		return Response.ok().build();
	}
}