package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteInserirSapato {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatodao = new SapatoDAO(con);
		
		sapato.setTamanho(38);
		sapato.setPeso(250);
		sapato.setNome("Adalberto");
		sapato.setTipoTecido("Borracha");

		System.out.println(sapatodao.inserir(sapato));
		
		Conexao.fecharConexao(con);

	}

}
