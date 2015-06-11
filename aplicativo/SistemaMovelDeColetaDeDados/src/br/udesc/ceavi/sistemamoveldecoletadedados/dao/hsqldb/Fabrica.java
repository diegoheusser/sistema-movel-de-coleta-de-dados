package br.udesc.ceavi.sistemamoveldecoletadedados.dao.hsqldb;

import br.udesc.ceavi.sistemamoveldecoletadedados.dao.fonte.Fonte;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisa.Pesquisa;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisador.Pesquisador;
import br.udesc.ceavi.sistemamoveldecoletadedados.dao.produto.Produto;


public class Fabrica extends br.udesc.ceavi.sistemamoveldecoletadedados.dao.core.Fabrica {

	public Fabrica() {
	}

	@Override
	public Fonte getFonte() {
		return new br.udesc.ceavi.sistemamoveldecoletadedados.dao.fonte.FonteHSQLDB();
	}

	@Override
	public Pesquisa getPesquisa() {
		return new br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisa.PesquisaHSQLDB();
	}

	@Override
	public Pesquisador getPesquisador() {
		return new br.udesc.ceavi.sistemamoveldecoletadedados.dao.pesquisador.PesquisadorHSQLDB();
	}

	@Override
	public Produto getProduto() {
		return new br.udesc.ceavi.sistemamoveldecoletadedados.dao.produto.ProdutoHSQLDB();
	}

}
