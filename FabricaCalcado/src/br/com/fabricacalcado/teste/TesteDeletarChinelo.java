package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteDeletarChinelo {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Chinelo chinelo = new Chinelo();
		ChineloDAO chinelodao = new ChineloDAO(con);
		
		chinelo.setNome("Adalberto");

		System.out.println(chinelodao.deletar(chinelo));
		
		Conexao.fecharConexao(con);
		
	}

}
