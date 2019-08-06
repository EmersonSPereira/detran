package br.com.ctis.detran.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.detran.enumeration.MultasEnum;
import br.com.ctis.detran.persistence.model.Multa;
import br.com.ctis.detran.persistence.model.Veiculo;
import br.com.ctis.detran.service.MultaService;
import br.com.ctis.detran.service.VeiculoService;

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
	public List<Multa> consultarMultasPorplaca(String placa) {

		return ordenarMultasPorData (veiculoService.buscarVeiculoPorPlaca(placa).getMultas());
	}

	@Override
	public List<Multa> consultarMultasPorCpfCnpj(String cpfCnpj) {
		
		List<Multa> multas = new ArrayList<Multa>();
		for(Veiculo veiculo : veiculoService.buscarVeiculoPorCpfCnpjProprietario(cpfCnpj)) {
			
			if(!multas.containsAll(veiculo.getMultas())) {
				multas.addAll(veiculo.getMultas());
			}
		}
		return ordenarMultasPorData(multas);
	}
	
	/**
	 * ordena uma lista de multas pela data
	 * 
	 * @param multas - a serem ordenada
	 * @return {@link List<Multa>} lista ordenada
	 */
	private List<Multa> ordenarMultasPorData(List<Multa> multas){
		
		return multas.stream()
				.sorted((multa1, multa2) -> multa1.getData().compareTo(multa2.getData()))
				.collect(Collectors.toList());
	}

}
