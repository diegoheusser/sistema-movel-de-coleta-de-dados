package br.udesc.ceavi.sistemamoveldecoletadedados.dao.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import android.widget.Toast;



public class Conexao {

	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		Class.forName("org.hsqldb.jdbc.JDBCDriver");	
		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:db/cliente", "SA", "");			
		Statement stmt = con.createStatement();
		stmt.execute("drop table cliente if exists;");          					
		stmt.execute("create table cliente (clienteId integer, nome varchar(100), cpf varchar(11), CONSTRAINT PK_Cliente PRIMARY KEY (clienteID));");          	
		return con;
	}
}
