package com.lakshmi.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.lakshmi.restws.model.patient;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/patientserivce")
public interface patientserivce {
	@Path("/patients")
	@GET
	List<patient> getpatients();
	
	@Path("/patients/{id}")
	@GET
	patient getpatient(@PathParam(value="id")long id);
	
	@Path("/patients")
	@POST
	Response createPatient(patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value="id")long id);
	

}
