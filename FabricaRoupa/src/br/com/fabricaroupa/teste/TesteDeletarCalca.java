package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteDeletarCalca {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcadao = new CalcaDAO(con);
		
		calca.setPeso(17);

		System.out.println(calcadao.deletar(calca));
		
		Conexao.fecharConexao(con);

	}

}
