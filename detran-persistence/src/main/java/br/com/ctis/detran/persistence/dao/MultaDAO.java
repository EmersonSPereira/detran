package br.com.ctis.detran.persistence.dao;

import javax.ejb.Local;

import br.com.ctis.detran.persistence.model.Multa;

@Local
public interface MultaDAO extends GenericDAO<Long, Multa> {

}
