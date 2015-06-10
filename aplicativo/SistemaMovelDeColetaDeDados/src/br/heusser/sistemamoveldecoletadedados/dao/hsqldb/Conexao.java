package br.heusser.sistemamoveldecoletadedados.dao.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	public static Connection getConexao(){
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			return DriverManager.getConnection("jdbc:hsqldb:file:db/custo-vida-movel", "SA", "");
		} catch(ClassNotFoundException ex){
		} catch (SQLException e) {
		}
		return null;
	}
}
