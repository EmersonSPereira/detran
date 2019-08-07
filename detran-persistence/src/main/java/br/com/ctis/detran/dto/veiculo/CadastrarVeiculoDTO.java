package br.com.ctis.detran.dto.veiculo;

import javax.validation.constraints.NotNull;

import br.com.ctis.detran.dto.BaseDTO;
import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.persistence.model.Proprietario;

public class CadastrarVeiculoDTO extends BaseDTO {

	private static final long serialVersionUID = 8604060815895310762L;
	
	@NotNull(message = "Cor não pode ser nulo")
	private String cor;

	@NotNull(message = "Renavan não pode ser nulo")
	private String renavan;

	@NotNull(message = "Marca não pode ser nulo")
	private String marca;

	@NotNull(message = "Nome não pode ser nulo")
	private String nome;

	@NotNull(message = "Ano não pode ser nulo")
	private Integer ano;

	private ProprietarioDTO proprietario;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public ProprietarioDTO getProprietario() {
		return proprietario;
	}

	public void setProprietario(ProprietarioDTO proprietario) {
		this.proprietario = proprietario;
	}



}
