package br.com.fabricaroupa.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fabricaroupa.dao.BlusaDAO;
import br.com.fabricaroupa.model.Blusa;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteSelecionarBlusa {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		BlusaDAO blusadao = new BlusaDAO(con);

		ArrayList<Blusa> lista = blusadao.retornarDadosBlusa();

		if (lista != null) {
			for (Blusa blusa : lista) {
				System.out.println("Tamanho do blusa: " + blusa.getPeso());
				System.out.println("Peso do blusa: " + blusa.getTipoTecido());
				System.out.println("Nome do blusa: " + blusa.getTouca() +
				"\n"
						);;
			}
		}
		Conexao.fecharConexao(con);

	}

}
