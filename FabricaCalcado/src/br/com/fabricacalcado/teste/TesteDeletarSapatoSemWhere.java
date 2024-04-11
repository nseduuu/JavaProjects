package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteDeletarSapatoSemWhere {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);
		
		sapato.setNome("Edu");

		System.out.println(sapatodao.deletarSemWhere(sapato));
		
		Conexao.fecharConexao(con);

	}

}
