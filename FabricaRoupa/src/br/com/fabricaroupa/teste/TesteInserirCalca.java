package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteInserirCalca {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcadao = new CalcaDAO(con);
		
		calca.setPeso(45);
		calca.setTipoTecido("Algodao");
		calca.setTipo("Moletom");

		System.out.println(calcadao.inserir(calca));
		
		Conexao.fecharConexao(con);

	}

}
