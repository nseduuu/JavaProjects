package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.dao.BlusaDAO;
import br.com.fabricaroupa.model.Blusa;
import br.com.fabricaroupa.conexao.Conexao;

public class TesteInserirBlusa {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Blusa blusa = new Blusa();
		BlusaDAO blusadao = new BlusaDAO(con);
		
		blusa.setPeso(15);
		blusa.setTipoTecido("Algodao");
		blusa.setTouca("Nao");

		System.out.println(blusadao.inserir(blusa));
		
		Conexao.fecharConexao(con);
		
	}

}
