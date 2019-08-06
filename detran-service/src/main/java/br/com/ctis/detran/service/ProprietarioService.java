package br.com.ctis.detran.service;

import javax.ejb.Local;

import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.persistence.model.Proprietario;

@Local
public interface ProprietarioService extends GenericService<Long, Proprietario> {
	
	/**
	 * Busca o proprietário pelo cpf ou cnpj
	 * 
	 * @param cpfCnpj - cpf ou cnpj do propriétario do veículo
	 * @return {@link Proprietario} - Proprietario cadastrado no sistema
	 */
	Proprietario buscarProprietarioPorCpfCnpJ( String cpfCnpj);
	
	/**
	 * Edita um Proprietário
	 * 
	 * @param id - id do Proprietário
	 * @param proprietarioDTO - dto com as aterações a serem feitas
	 */
	void editarProprietario(Long id, ProprietarioDTO proprietarioDTO);

}
