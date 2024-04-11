package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteDeletarCalcaSemWhere {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcadao = new CalcaDAO(con);
		
		calca.setPeso(23);

		System.out.println(calcadao.deletarSemWhere(calca));
		
		Conexao.fecharConexao(con);

	}

}
