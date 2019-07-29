package br.com.ctis.detran.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.dao.ProprietarioDAO;
import br.com.ctis.detran.persistence.model.Proprietario;

@Stateless
public class ProprietarioDAOImpl extends GenericDAOImpl<Long, Proprietario> implements ProprietarioDAO {

	@Override
	public Proprietario buscarProprietarioPorCpfCnpJ(String cpfCnpj)
			throws RegistroNaoEncontradoException, DAOException {

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT p FROM Proprietario p ")
		.append("WHERE p.cpfCnpj = :cpfCnpj");

		TypedQuery<Proprietario> query = getEntityManager().createQuery(builder.toString(), Proprietario.class);
		query.setParameter("cpfCnpj", cpfCnpj);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}

}
