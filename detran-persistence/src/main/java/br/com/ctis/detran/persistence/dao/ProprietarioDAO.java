package br.com.ctis.detran.persistence.dao;

import javax.ejb.Local;

import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.model.Proprietario;

@Local
public interface ProprietarioDAO extends GenericDAO<Long, Proprietario> {

	Proprietario buscarProprietarioPorCpfCnpJ( String cpfCnpj) throws RegistroNaoEncontradoException, DAOException;
}
