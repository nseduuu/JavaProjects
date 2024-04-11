package br.com.fabricaroupa.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteSelecionarCalcaComWhere {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		CalcaDAO calcadao = new CalcaDAO(con);

		String tipo = "Moletom";
		
		ArrayList<Calca> lista = calcadao.retornarDadosCalcaComWhere(tipo);
	
		if (lista != null) {
			for (Calca calca : lista) {
				System.out.println("Tamanho do calca: " + calca.getPeso());
				System.out.println("Peso do calca: " + calca.getTipoTecido());
				System.out.println("Nome do calca: " + calca.getTipo() +
				"\n"
						);;	
			}
		}
		Conexao.fecharConexao(con);

	}

}
