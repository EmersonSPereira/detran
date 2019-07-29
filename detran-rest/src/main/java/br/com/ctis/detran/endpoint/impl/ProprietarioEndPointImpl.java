package br.com.ctis.detran.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.detran.endpoint.ProprietarioEndPoint;
import br.com.ctis.detran.service.ProprietarioService;

public class ProprietarioEndPointImpl implements ProprietarioEndPoint {

	@EJB
	private ProprietarioService proprietarioService;
	
	@Override
	public Response consultarProprietarioPorCpfCnpj(String cpfCnpj) {
		
		return Response.status(Status.OK).entity(proprietarioService.buscarProprietarioPorCpfCnpJ(cpfCnpj)).build();
	}

}
