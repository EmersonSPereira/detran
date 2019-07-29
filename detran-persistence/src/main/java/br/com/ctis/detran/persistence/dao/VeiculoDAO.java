package br.com.ctis.detran.persistence.dao;

import javax.ejb.Local;

import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.model.Veiculo;

@Local
public interface VeiculoDAO extends GenericDAO<Long, Veiculo> {

	Veiculo buscarVeiculoPorId(Long id) throws RegistroNaoEncontradoException, DAOException;
	
	Veiculo buscarVeiculoPorPlaca(String placa) throws RegistroNaoEncontradoException, DAOException;
	
	Veiculo buscarVeiculoPorCpfCnpjProprietario(String cpfCnpj) throws RegistroNaoEncontradoException, DAOException;
	
	Veiculo buscarVeiculoPorPlacaOuCpfCnpj(String placaOucpfCnpj)throws RegistroNaoEncontradoException, DAOException;
}
