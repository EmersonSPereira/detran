package br.com.ctis.detran.dto.endereco;

import javax.validation.constraints.NotNull;

import br.com.ctis.detran.dto.BaseDTO;

public class EnderecoDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String rua;

	@NotNull
	private String numero;

	@NotNull
	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	private String estado;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
