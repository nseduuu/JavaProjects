package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteInserirChinelo {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Chinelo chinelo = new Chinelo();
		ChineloDAO chinelodao = new ChineloDAO(con);
		
		chinelo.setTamanho(40);
		chinelo.setPeso(250);
		chinelo.setNome("Edu");
		chinelo.setQuantdadeTiras(2);

		System.out.println(chinelodao.inserir(chinelo));
		
		Conexao.fecharConexao(con);
		
	}

}
