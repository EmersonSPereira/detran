package br.com.ctis.detran.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.detran.enumeration.MensagemEnum;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.NegocioException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.dao.ProprietarioDAO;
import br.com.ctis.detran.persistence.model.Proprietario;
import br.com.ctis.detran.service.ProprietarioService;
import br.com.ctis.detran.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProprietarioServiceImpl  extends GenericServiceImpl<Long, Proprietario> implements ProprietarioService{


	private static final long serialVersionUID = 4730533983797017209L;
	
	@EJB
	private ProprietarioDAO proprietarioDAO;
	
	@Override
	public Proprietario buscarProprietarioPorCpfCnpJ(String cpfCnpj) {

		try {
			return proprietarioDAO.buscarProprietarioPorCpfCnpJ(cpfCnpj);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG002));
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}

}
