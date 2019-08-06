package br.com.ctis.detran.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.detran.dto.MensagemRetornoDTO;
import br.com.ctis.detran.dto.multa.MultaDTO;
import br.com.ctis.detran.service.MultaService;

public class MultasEndPointImpl implements br.com.ctis.detran.endpoint.MultasEndPoint {

	@EJB
	private MultaService multaService;

	@Override
	public Response consultarMultasPorPlaca(String placa) {
		return Response.status(Status.OK).entity(multaService.consultarMultasPorplaca(placa)).build();
	}

	@Override
	public Response cadastrar(String placa, MultaDTO multaDTO) {
		multaService.multarVeiculo(placa, multaDTO.getMultasEnum());
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Multa Aplicada com sucesso!")).build();
	}

	@Override
	public Response deletarMultaPorId(Long id) {
		multaService.excluir(id);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Multa deletada com sucesso!")).build();
		
	}

	

}
