package br.com.ctis.detran.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import br.com.ctis.detran.enumeration.MensagemEnum;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.NegocioException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.mapper.VeiculoMapper;
import br.com.ctis.detran.persistence.dao.VeiculoDAO;
import br.com.ctis.detran.persistence.model.Veiculo;
import br.com.ctis.detran.service.ProprietarioService;
import br.com.ctis.detran.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class VeiculoServiceImpl extends GenericServiceImpl<Long, Veiculo>
		implements br.com.ctis.detran.service.VeiculoService {

	private static final long serialVersionUID = -4192951350922664173L;

	@EJB
	private VeiculoDAO veiculoDAO;
	
	@EJB
	private ProprietarioService proprietarioService;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarVeiculo(CadastrarVeiculoDTO veiculoDTO) {

		Veiculo veiculo = VeiculoMapper.mapper(veiculoDTO);
		veiculo.setPlaca(gerarPlaca());
				
		veiculoDAO.gravar(veiculo);

	}

	/**
	 * Gera uma placa aleátoria
	 * @return {@link String} - String contendo a placa gerada
	 */
	private String gerarPlaca() {

		String letras = RandomStringUtils.random(3, true, false);

		String numeros = RandomStringUtils.random(4, false, true);

		StringBuilder placaBuilder = new StringBuilder();
		placaBuilder.append(letras);
		placaBuilder.append(numeros);

		String placa = placaBuilder.toString().toUpperCase();

		return verificarSePlacaExiste(placa) == false ? placa : gerarPlaca();
	}

	@Override
	public Veiculo buscarVeiculoPorPlaca(String placa) {
		try {
			return veiculoDAO.buscarVeiculoPorPlaca(placa);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG002));
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}

	/**
	 * verifica se a placa passada como parâmetro já existe na base
	 * @param placa - placa a ser consultada
	 * @return
	 */
	private Boolean verificarSePlacaExiste(String placa) {
		try {
			buscarVeiculoPorPlaca(placa);
			return true;
		}catch (NegocioException e) {
			return false;
		}
		
	}

	@Override
	public List<Veiculo> buscarVeiculoPorCpfCnpjProprietario(String cpfCnpj) {
		try {
			return veiculoDAO.buscarVeiculoPorCpfCnpjProprietario(cpfCnpj);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG002));
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}


	
	public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}
}
