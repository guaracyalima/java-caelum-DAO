package br.com.caelum.jdbc.testes;

import java.sql.SQLException;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		
		contato.setId();
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		
		System.out.println("Operação realizada com sucesso!");
		
	}

}
