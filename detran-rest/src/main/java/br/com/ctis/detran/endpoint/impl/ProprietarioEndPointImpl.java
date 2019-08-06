package br.com.ctis.detran.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.detran.dto.MensagemRetornoDTO;
import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.endpoint.ProprietarioEndPoint;
import br.com.ctis.detran.service.MultaService;
import br.com.ctis.detran.service.ProprietarioService;

public class ProprietarioEndPointImpl implements ProprietarioEndPoint {

	@EJB
	private ProprietarioService proprietarioService;

	@EJB
	private MultaService multaService;

	@Override
	public Response consultarProprietarioPorCpfCnpj(String cpfCnpj) {

		return Response.status(Status.OK).entity(proprietarioService.buscarProprietarioPorCpfCnpJ(cpfCnpj)).build();
	}

	@Override
	public Response consultarMultasPorCpfCnpj(String CpfCnpj) {
		return Response.status(Status.OK).entity(multaService.consultarMultasPorCpfCnpj(CpfCnpj)).build();

	}

	@Override
	public Response editarProprietario(Long id, ProprietarioDTO proprietarioDTO) {
		proprietarioService.editarProprietario(id, proprietarioDTO);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Sucesso ao editar Porprietário")).build();
	}
}