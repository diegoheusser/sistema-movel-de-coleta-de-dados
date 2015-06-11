package br.udesc.ceavi.sistemamoveldecoletadedados.dao.core;

import br.udesc.ceavi.sistemamoveldecoletadedados.dao.fonte.Fonte;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisa.Pesquisa;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisador.Pesquisador;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.produto.Produto;


public abstract class Fabrica {

	public static Fabrica getInstancia(){
		return new br.udesc.ceavi.sistemamoveldecoletadedados.dao.hsqldb.Fabrica();
	}
	
	public abstract Fonte getFonte();
	public abstract Pesquisa getPesquisa();
	public abstract Pesquisador getPesquisador();
	public abstract Produto getProduto();
}
