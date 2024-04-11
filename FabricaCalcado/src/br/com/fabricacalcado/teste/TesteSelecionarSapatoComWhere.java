package br.com.fabricacalcado.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteSelecionarSapatoComWhere {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		SapatoDAO sapatodao = new SapatoDAO(con);

		ArrayList<Sapato> lista = sapatodao.retornarDadosSapato();

		if (lista != null) {
			for (Sapato sapato : lista) {
				System.out.println("Tamanho do sapato: " + sapato.getTamanho());
				System.out.println("Peso do sapato: " + sapato.getPeso());
				System.out.println("Nome do sapato: " + sapato.getNome());
				System.out.println("Quantidade de tiras do sapato " + sapato.getTipoTecido() +
				"\n"
						);;	
			}
		}
		Conexao.fecharConexao(con);

	}

}
