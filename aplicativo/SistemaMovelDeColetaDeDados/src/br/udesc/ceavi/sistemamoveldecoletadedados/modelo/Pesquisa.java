package br.udesc.ceavi.sistemamoveldecoletadedados.modelo;

import java.util.Date;

public class Pesquisa {

	private int codigo;
	private Date data;
	private String marca;
	private String especificacao;
	private boolean mudouMarca;
	private double valor;
	private Produto produto;
	private Pesquisador pesquisador;
	private Fonte fonte;
	
	public Pesquisa() {
		codigo = 0;
		data = null;
		marca = "";
		especificacao = "";
		mudouMarca = false;
		valor = 0;
		produto = new Produto();
		pesquisador = new Pesquisador();
		fonte = new Fonte();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public boolean isMudouMarca() {
		return mudouMarca;
	}

	public void setMudouMarca(boolean mudouMarca) {
		this.mudouMarca = mudouMarca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

}
