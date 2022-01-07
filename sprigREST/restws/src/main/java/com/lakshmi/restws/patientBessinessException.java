package com.lakshmi.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lakshmi.restws.exception.patientBesineesException;
@Provider
public class patientBessinessException implements ExceptionMapper<patientBesineesException> {

	@Override
	public Response toResponse(patientBesineesException exception) {
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("{");
		sb.append("\"status\":\"error\"");
		
		sb.append(",");
		sb.append("\"message\":\"train agin\"");
		sb.append("}");
		
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
;