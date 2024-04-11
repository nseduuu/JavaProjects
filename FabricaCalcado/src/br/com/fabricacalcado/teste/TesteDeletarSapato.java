package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteDeletarSapato {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);
		
		sapato.setNome("Adalberto");

		System.out.println(sapatodao.deletar(sapato));
		
		Conexao.fecharConexao(con);

	}

}
