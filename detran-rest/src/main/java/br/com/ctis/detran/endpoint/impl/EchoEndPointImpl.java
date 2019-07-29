package br.com.ctis.detran.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.detran.dto.EchoDTO;
import br.com.ctis.detran.dto.MensagemRetornoDTO;
import br.com.ctis.detran.endpoint.EchoEndPoint;
import br.com.ctis.detran.service.EchoService;

public class EchoEndPointImpl implements EchoEndPoint {

	@EJB
	private EchoService echoService;
	
	@Override
	public Response listar() {
		return Response.status(Status.OK).entity(echoService.listarTodos()).build();
	}

	@Override
	public Response cadastrar(EchoDTO echoDTO) {
		echoService.cadastrar(echoDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Echo cadastrado com sucesso!")).build();
	}

	@Override
	public Response buscarEchoPorId(Long id) {
		return Response.status(Status.OK).entity(echoService.buscarEchoPorId(id)).build();
	}


}
