package br.heusser.sistemamoveldecoletadedados.modelo;

import java.util.ArrayList;
import java.util.List;

public class Fonte {

	private int codigo;
	private String nome;
	private String localizacao;
	private List<Pesquisador> pesquisadores;
	
	public Fonte() {
		codigo = 0;
		nome = "";
		localizacao = "";
		pesquisadores = new ArrayList<Pesquisador>();	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

}
