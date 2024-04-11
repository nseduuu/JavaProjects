package br.com.etecconexaobr.teste;

import java.sql.Connection;

import br.com.etecconexaobr.conexao.Conexao;
import br.com.etecconexaobr.dao.PessoaDAO;
import br.com.etecconexaobr.model.Pessoa;

public class TesteDeletar {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		pessoa.setNome("Rafael");

		System.out.println(pessoadao.deletar(pessoa));
		
		Conexao.fecharConexao(con);
		
	}

}
