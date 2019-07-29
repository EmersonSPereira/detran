package br.com.ctis.detran.dto.multa;

import javax.validation.constraints.NotNull;

import br.com.ctis.detran.dto.BaseDTO;
import br.com.ctis.detran.enumeration.MultasEnum;

public class MultaDTO extends BaseDTO {

	private static final long serialVersionUID = 3134679745197897644L;
	
	@NotNull(message = "O tipo da multa não pode ser nulo")
	private MultasEnum multasEnum;

	public MultasEnum getMultasEnum() {
		return multasEnum;
	}

	public void setMultasEnum(MultasEnum multasEnum) {
		this.multasEnum = multasEnum;
	}

}
