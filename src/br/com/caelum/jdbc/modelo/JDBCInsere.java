package br.com.caelum.jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.conexao.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		
		Connection con = new ConnectionFactory().getConnection();
		
		//Statement de insercao no db
		String sql = "insert into contatos" + 
		"(nome, email, endereco, dataNascimento)"+
				"values (?, ?, ?, ?)";
		
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, "Caelum");
		stm.setString(2, "contato@basis.com.br");
		stm.setString(3, "Brasilia DF");
		stm.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		stm.execute();
		stm.close();
		
		System.out.println("Dados persistidos com sucesso!");
		con.close();
		
	}
}
