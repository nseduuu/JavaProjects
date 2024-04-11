package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteUpdateSapato {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);
		
		sapato.setTamanho(28);
		sapato.setNome("Edu");

		System.out.println(sapatodao.alterarTamanhoSapato(sapato));
		
		Conexao.fecharConexao(con);

	}

}
