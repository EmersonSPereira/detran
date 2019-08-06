package br.com.ctis.detran.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.detran.dto.MensagemRetornoDTO;
import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import br.com.ctis.detran.endpoint.VeiculoEndPoint;
import br.com.ctis.detran.service.VeiculoService;

public class VeiculoEndPointImpl implements VeiculoEndPoint {

	@EJB
	private VeiculoService veiculoService;

	@Override
	public Response cadastrarVeiculo(CadastrarVeiculoDTO veiculoDTO) {

		veiculoService.cadastrarVeiculo(veiculoDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Veículo cadastrado com sucesso!"))
				.build();
	}

	@Override
	public Response deletarVeiculoPorId(Long id) {
		veiculoService.excluir(id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Veículo deletado com sucesso!"))
				.build();
	}

}
