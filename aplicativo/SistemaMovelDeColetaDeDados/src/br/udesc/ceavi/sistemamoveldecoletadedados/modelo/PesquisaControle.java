package br.udesc.ceavi.sistemamoveldecoletadedados.modelo;

import java.util.Date;

public class PesquisaControle {

	private int pesquisaControleId;
	private Date dataEmissao;
	private Date dataEntrega;
	private int semana;
	private int mes;
	private int ano;
	private boolean aberto;
	private Fonte fonte;
	private Pesquisador pesquisador;
	public int getPesquisaControleId() {
		return pesquisaControleId;
	}
	public void setPesquisaControleId(int pesquisaControleId) {
		this.pesquisaControleId = pesquisaControleId;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	public Fonte getFonte() {
		return fonte;
	}
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}
	public Pesquisador getPesquisador() {
		return pesquisador;
	}
	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}
	
	

}
