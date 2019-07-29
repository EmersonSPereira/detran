package br.com.ctis.detran.enumeration;

public enum MultasEnum {
	LEVE("leve", 3, 53.2),
	MEDIA("media", 4, 85.13),
	GRAVE("grave", 5, 191.54),
	GRAVISSIMA("Gravissima", 7, 293.47);
	
	
	private String descricao;
	
	private int pontos;
	
	private double valor;
	
	private MultasEnum(String descricao, int pontos, double valor) {
		this.descricao = descricao;
		this.pontos = pontos;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPontos() {
		return pontos;
	}

	public double getValor() {
		return valor;
	}
}
