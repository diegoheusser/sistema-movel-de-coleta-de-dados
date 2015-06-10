package br.heusser.sistemamoveldecoletadedados.modelo;

import java.util.ArrayList;
import java.util.List;

import br.heusser.sistemamoveldecoletadedados.dao.hsqldb.Fabrica;

public class Pesquisador {

	private int codigo;
	private String nome;
	private String usuario;
	private String senha;
	private List<Fonte> fontes;
	
	public Pesquisador() {
		codigo = 0;
		nome = "";
		usuario = "";
		senha = "";
		fontes = new ArrayList<Fonte>();
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Fonte> getFontes() {
		return fontes;
	}

	public void setFontes(List<Fonte> fontes) {
		this.fontes = fontes;
	}
	
	public static List<Pesquisador> listarTodos(){
		br.heusser.sistemamoveldecoletadedados.dao.pesquisador.Pesquisador p = Fabrica.getInstancia().getPesquisador();
		return p.listarTodos();
	}

}
