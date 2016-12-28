package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import br.com.caelum.jdbc.conexao.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	
	private Connection connection;
	Connection con = new ConnectionFactory().getConnection();
	public void ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adciona(Contato contato){
		String sql = "insert into contatos"+
	"(nome, email, endereco, dataNascimento)"+
				"values(?, ?, ?, ?)";
		
		
		try{ PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4,  new java.sql.Date( contato.getDataNascimento().getTimeInMillis()));			
			stm.execute();
			stm.close();			
		} catch (SQLException e){
			throw new RuntimeException(e);
			
		}
	}
	
	public List<Contato> getLista(){
		try{		
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stm = con.prepareStatement("select * from contatos");
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("email"));				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);				
				contatos.add(contato);					
			} 
			
			rs.close();
			stm.close();
			return contatos;
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato){
		String sql =  "update contatos set nome=?, email=?, endereco=?,"+"dataNascimento=? where id=?";
		
		try{
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stm.setLong(5, contato.getId());
			stm.execute();
			stm.close();						
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	public void remove(Contato contato){
		try {
			
			PreparedStatement stm = connection.prepareStatement("delete" + "from contatos where id=?");
			stm.setLong(1, contato.getId());
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

}
