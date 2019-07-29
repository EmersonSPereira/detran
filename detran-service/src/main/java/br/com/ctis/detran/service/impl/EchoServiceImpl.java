package br.com.ctis.detran.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.detran.dto.EchoDTO;
import br.com.ctis.detran.enumeration.MensagemEnum;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.NegocioException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.dao.EchoDAO;
import br.com.ctis.detran.persistence.model.Echo;
import br.com.ctis.detran.service.EchoService;
import br.com.ctis.detran.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EchoServiceImpl extends GenericServiceImpl<Long, Echo> implements EchoService {

	private static final long serialVersionUID = -4974991595955674384L;

	@EJB
	private EchoDAO echoDAO;

	@Override
	public List<Echo> listarTodos() {

		try {
			return echoDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(EchoDTO echoDTO) {

		echoDAO.gravar(mapper(echoDTO));

	}

	@Override
	public Echo buscarEchoPorId(Long id) {

		try {
			return echoDAO.buscarEchoPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Echo com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	/**
	 * Converter EchoDTO para entidade Echo
	 * 
	 * @param echoDTO - DTO que será convertido
	 * 
	 * @return {@link Echo} - Entidade Echo
	 */
	private Echo mapper(EchoDTO echoDTO) {

		Echo echo = new Echo();
		echo.setCodigo(echoDTO.getCodigo());
		echo.setNome(echoDTO.getNome());

		return echo;

	}

}
