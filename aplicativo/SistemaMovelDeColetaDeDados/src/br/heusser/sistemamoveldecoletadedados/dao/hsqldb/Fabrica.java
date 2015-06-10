package br.heusser.sistemamoveldecoletadedados.dao.hsqldb;

import br.heusser.sistemamoveldecoletadedados.dao.fonte.Fonte;
import br.heusser.sistemamoveldecoletadedados.dao.pesquisa.Pesquisa;
import br.heusser.sistemamoveldecoletadedados.dao.pesquisador.Pesquisador;
import br.heusser.sistemamoveldecoletadedados.dao.produto.Produto;


public class Fabrica extends br.heusser.sistemamoveldecoletadedados.dao.core.Fabrica {

	public Fabrica() {
	}

	@Override
	public Fonte getFonte() {
		return new br.heusser.sistemamoveldecoletadedados.dao.fonte.FonteHSQLDB();
	}

	@Override
	public Pesquisa getPesquisa() {
		return new br.heusser.sistemamoveldecoletadedados.dao.pesquisa.PesquisaHSQLDB();
	}

	@Override
	public Pesquisador getPesquisador() {
		return new br.heusser.sistemamoveldecoletadedados.dao.pesquisador.PesquisadorHSQLDB();
	}

	@Override
	public Produto getProduto() {
		return new br.heusser.sistemamoveldecoletadedados.dao.produto.ProdutoHSQLDB();
	}

}
