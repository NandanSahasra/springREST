package com.lakshmi.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.lakshmi.restws.exception.patientBesineesException;
import com.lakshmi.restws.model.patient;

@Service
public class patientserviceimpl implements patientserivce {
	Map<Long,patient> patients=new HashMap<>();
	
	long currentid=123;
	public patientserviceimpl() {
		
		init() ;
		
	}
	
	public void init() {
		 patient patient=new patient();
		 patient.setId(currentid);
		 
		 patient.setName("sai");
		 patients.put(patient.getId(), patient);
		 
		 
		
	}

	@Override
	public List<patient> getpatients() {
		Collection<patient> result = patients.values();
		List<patient> response = new ArrayList<patient>(result);
		return response;
	}

	@Override
	public patient getpatient(long id) {
		
		if(patients.get(id)==null)
			
		{
			//throw new WebApplicationException(Response.Status.NOT_FOUND);
			throw new NotFoundException();
			
		}
		return patients.get(id);
	}
//exception mappers
	@Override
	public Response createPatient(patient patient) {
		patient.setId(++currentid);
		patients.put(patient.getId(), patient);
		
		
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(patient patient) {
		
	  patient currentpatient = patients.get(patient.getId());
	  Response response;
	  if(currentpatient!=null)
	  { 
		 patients.put(patient.getId(), patient);
		 
		 throw new patientBesineesException();
		 //response= Response.ok(patient).build();
	 }  
	  else
	  { 
		  response=  Response.notModified().build();
	   }  
	  
	  return response;
	}

	@Override
	public Response deletePatient(long id) {
		 patient patient = patients.get(id);
		 
		 Response response;
		  if(patient!=null)
		  { 
			 patients.remove(id);
			 response= Response.ok(patient).build();
		 }  
		  else
		  { 
			  response=  Response.notModified().build();
		   }  
		  
		  return response;
		}
	}
	
	

