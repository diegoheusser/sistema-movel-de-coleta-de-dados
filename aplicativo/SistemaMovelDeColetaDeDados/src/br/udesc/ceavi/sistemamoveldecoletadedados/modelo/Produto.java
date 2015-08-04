package br.udesc.ceavi.sistemamoveldecoletadedados.modelo;

public class Produto {

	private int codigo;
	private String descricao;
	private String identificador;
	
	public Produto() {
		codigo = 0;
		descricao = "";
		identificador = "";
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	
}
