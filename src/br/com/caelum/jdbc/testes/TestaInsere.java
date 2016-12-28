package br.com.caelum.jdbc.testes;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Elaynne Anselmo");
		contato.setEmail("elaynneanselmo@gmail.com");
		contato.setEndereco("Rua da minha cama");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		
		dao.adciona(contato);
		
		System.out.println("Gravado com sucesso!");		
	}
}
