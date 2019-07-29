package br.com.ctis.detran.service;

import javax.ejb.Local;

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

}
