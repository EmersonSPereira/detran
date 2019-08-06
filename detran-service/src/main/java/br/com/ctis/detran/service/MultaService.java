package br.com.ctis.detran.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.enumeration.MultasEnum;
import br.com.ctis.detran.persistence.model.Multa;

@Local
public interface MultaService extends GenericService<Long, Multa> {

	/**
	 * Aplica uma multa no veiculo com a placa passada como parâmetro
	 * 
	 * @param placa - Placa do veículo
	 * @param multasEnum - Tipo de multa que vai ser aplicada
	 */
	void multarVeiculo(String placa, MultasEnum multasEnum);
	
	
	/**
	 * 
	 * Lista todas as multas do veículo com a placa passada como parâmetro
	 * 
	 * @param placa - placa do veículo que será consultado
	 * @return {@link List<Multa>} - Lista com as multas do veículo
	 */
	List<Multa> consultarMultasPorplaca(String placa);
	
	/**
	 * 
	 * Lista todas as multas do Proprietário com o cpfCnpj passada como parâmetro
	 * 
	 * @param cpfCnpj - cpfCnpj do veículo que será consultado
	 * @return {@link List<Multa>} - Lista com as multas do veículo
	 */
	List<Multa> consultarMultasPorCpfCnpj(String cpfCnpj);


	
}
