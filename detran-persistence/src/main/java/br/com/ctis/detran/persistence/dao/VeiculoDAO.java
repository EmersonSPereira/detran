package br.com.ctis.detran.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.model.Veiculo;

@Local
public interface VeiculoDAO extends GenericDAO<Long, Veiculo> {

	Veiculo buscarVeiculoPorId(Long id) throws RegistroNaoEncontradoException, DAOException;
	
	Veiculo buscarVeiculoPorPlaca(String placa) throws RegistroNaoEncontradoException, DAOException;
	
	List<Veiculo> buscarVeiculoPorCpfCnpjProprietario(String cpfCnpj) throws RegistroNaoEncontradoException, DAOException;
	
	
}
