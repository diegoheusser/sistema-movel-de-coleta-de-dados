package br.heusser.sistemamoveldecoletadedados.modelo;

public class Produto {

	private int codigo;
	private String descricao;
	
	public Produto() {
		codigo = 0;
		descricao = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
