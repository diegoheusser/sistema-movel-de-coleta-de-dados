package br.heusser.sistemamoveldecoletadedados.dao.core;

import br.heusser.sistemamoveldecoletadedados.dao.fonte.Fonte;
import br.heusser.sistemamoveldecoletadedados.dao.pesquisa.Pesquisa;
import br.heusser.sistemamoveldecoletadedados.dao.pesquisador.Pesquisador;
import br.heusser.sistemamoveldecoletadedados.dao.produto.Produto;


public abstract class Fabrica {

	public static Fabrica getInstancia(){
		return new br.heusser.sistemamoveldecoletadedados.dao.hsqldb.Fabrica();
	}
	
	public abstract Fonte getFonte();
	public abstract Pesquisa getPesquisa();
	public abstract Pesquisador getPesquisador();
	public abstract Produto getProduto();
}
