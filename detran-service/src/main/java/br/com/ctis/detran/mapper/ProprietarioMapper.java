package br.com.ctis.detran.mapper;

import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.persistence.model.Proprietario;

public class ProprietarioMapper {
	
	
	public static Proprietario mapper(Proprietario proprietario, ProprietarioDTO proprietarioDTO ) {
		
		proprietario.setNome(proprietarioDTO.getNome());
		proprietario.setCnh(proprietarioDTO.getCnh());
		proprietario.setCpfCnpj(proprietarioDTO.getCpfCnpj());
		proprietario.setRg(proprietarioDTO.getRg());
		proprietario.setEndereco(EnderecoMapper.mapper(proprietario.getEndereco(), proprietarioDTO.getEndereco()));
		return proprietario;
	}

}
