package br.com.ctis.detran.mapper;

import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import br.com.ctis.detran.persistence.model.Veiculo;

public class VeiculoMapper {

	public static Veiculo mapper(CadastrarVeiculoDTO veiculoDto) {
		Veiculo veiculo = new Veiculo();
		veiculo.setAno(veiculoDto.getAno());
		veiculo.setCor(veiculoDto.getCor());
		veiculo.setMarca(veiculoDto.getCor());
		veiculo.setNome(veiculoDto.getNome());
		veiculo.setRenavan(veiculoDto.getRenavan());
		veiculo.setProprietario(veiculoDto.getProprietario());
		return veiculo;
	}
}
