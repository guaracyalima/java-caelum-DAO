package br.com.caelum.jdbc.dao;

import java.util.Calendar;

import br.com.caelum.jdbc.modelo.Contato;

public class TestaAlteracao {

	public static void main(String[] args) {
		Contato c = new Contato();
			c.setNome("Guabiraba's");
			c.setEmail("guabiraba@gmail.com");
			c.setEndereco("Rua da ponta");
			c.setDataNascimento(Calendar.getInstance());
			c.setId(c.getId());
		
		ContatoDAO dao = new ContatoDAO();
		dao.altera(c);
		
		System.out.println("Contato alterado com sucesso!");
		
	}
}
