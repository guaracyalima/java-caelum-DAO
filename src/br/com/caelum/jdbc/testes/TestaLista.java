package br.com.caelum.jdbc.testes;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			
			System.out.println("Nome.: "+contato.getNome());
			System.out.println("Email.: "+contato.getEmail());
			System.out.println("Endereco.: "+contato.getEndereco());
			System.out.println("Nascimento.: "+contato.getDataNascimento().getTime()+"\n");
			
		}
	}
}
