package br.com.ctis.detran.mapper;

import br.com.ctis.detran.dto.endereco.EnderecoDTO;
import br.com.ctis.detran.persistence.model.Endereco;

public class EnderecoMapper {

	public static Endereco mapper(Endereco endereco, EnderecoDTO enderecoDTO) {

		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getBairro());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());
		return endereco;
	}

	public static Endereco mapper(EnderecoDTO enderecoDTO) {

		Endereco endereco = new Endereco();
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getBairro());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());
		return endereco;
	}

}
