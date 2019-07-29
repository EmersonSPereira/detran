package br.com.ctis.detran.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.detran.enumeration.MensagemEnum;
import br.com.ctis.detran.enumeration.MultasEnum;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.NegocioException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.model.Multa;
import br.com.ctis.detran.persistence.model.Veiculo;
import br.com.ctis.detran.service.MultaService;
import br.com.ctis.detran.service.VeiculoService;
import br.com.ctis.detran.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MultaServiceImpl extends GenericServiceImpl<Long, Multa> implements MultaService {

	private static final long serialVersionUID = -30146558984045978L;

	@EJB
	private VeiculoService veiculoService;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void multarVeiculo(String placa, MultasEnum multasEnum) {

		Veiculo veiculo = veiculoService.buscarVeiculoPorPlaca(placa);

		if (veiculo != null) {

			veiculo.getMultas().add(gerarMulta(multasEnum));

			veiculoService.gravar(veiculo);
		}

	}

	private Multa gerarMulta(MultasEnum enumMulta) {

		Multa multa = new Multa();
		multa.setData(new Date());
		multa.setPontos(enumMulta.getPontos());
		multa.setTipo(enumMulta.getDescricao());
		multa.setValor(enumMulta.getValor());
		return multa;
	}

	@Override
	public List<Multa> consultarMultas(String placa) {
		
		try {
			return veiculoService.buscarVeiculoPorPlacaOuCpfCnpj(placa).getMultas();
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG002));
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}

}
