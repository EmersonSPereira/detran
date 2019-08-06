package br.com.ctis.detran.dto.proprietario;

import javax.validation.constraints.NotNull;

import br.com.ctis.detran.dto.BaseDTO;
import br.com.ctis.detran.dto.endereco.EnderecoDTO;

public class ProprietarioDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String cpfCnpj;

	@NotNull
	private String nome;

	@NotNull
	private String rg;

	@NotNull
	private String cnh;

	@NotNull
	private EnderecoDTO endereco;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
