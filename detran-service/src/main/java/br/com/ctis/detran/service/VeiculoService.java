package br.com.ctis.detran.service;

import javax.ejb.Local;

import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.model.Veiculo;

@Local
public interface VeiculoService extends GenericService<Long, Veiculo> {

	/**
	 * Cadastra um veículo e seu proprietario no sistema
	 * 
	 * @param veiculoDTO - Parâmetros de entrada para cadastrar um veiículo
	 */
	void CadastrarVeiculo(CadastrarVeiculoDTO veiculoDTO);
	
	/**
	 * Busca um veículo pela placa no sistema
	 * @param placa - placa do veículo que serar buscado
	 * @return {@link Veiculo} - um veículo cadastrado no sistema
	 */
	Veiculo buscarVeiculoPorPlaca(String placa);
	

	/**
	 * Busca um veículo pela placa no sistema
	 * @param placaOucpfCnpj - placa do veículo que serar buscado ou Cpf/Cnpj do proprietário do veículo
	 * @return {@link Veiculo} - um veículo cadastrado no sistema
	 */
	Veiculo buscarVeiculoPorPlacaOuCpfCnpj(String placaOucpfCnpj)throws RegistroNaoEncontradoException, DAOException;
}
