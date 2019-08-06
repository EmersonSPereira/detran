package br.com.ctis.detran.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.dao.VeiculoDAO;
import br.com.ctis.detran.persistence.model.Veiculo;

@Stateless
public class VeiculoDAOImpl extends GenericDAOImpl<Long, Veiculo> implements VeiculoDAO {


	
	private static final String ID = "id";
	private static final String CPF_CNPJ = "cpfCnpj";
	private static final String PLACA = "placa";

	public Veiculo buscarVeiculoPorId(Long id) throws RegistroNaoEncontradoException, DAOException {
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT v FROM Veiculo v ")
		.append("WHERE v.id =:id");
		
		TypedQuery<Veiculo> query = getEntityManager().createQuery(builder.toString(), Veiculo.class);
		query.setParameter(ID, id);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}

	@Override
	public Veiculo buscarVeiculoPorPlaca(String placa) throws RegistroNaoEncontradoException, DAOException {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT v FROM Veiculo v ")
		.append("LEFT JOIN FETCH v.multas ")
		.append("WHERE v.placa = :placa");
		
		TypedQuery<Veiculo> query = getEntityManager().createQuery(builder.toString(), Veiculo.class);
		query.setParameter(PLACA, placa);
		
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}

	@Override
	public List<Veiculo> buscarVeiculoPorCpfCnpjProprietario(String cpfCnpj)
			throws RegistroNaoEncontradoException, DAOException {
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT v FROM Veiculo v ")
		.append("INNER JOIN v.proprietario p ")
		.append("LEFT JOIN FETCH v.multas ")
		.append("WHERE p.cpfCnpj =:cpfCnpj");
		
		TypedQuery<Veiculo> query = getEntityManager().createQuery(builder.toString(), Veiculo.class);
		query.setParameter(CPF_CNPJ, cpfCnpj);
		
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
		
	}

	
	

}
