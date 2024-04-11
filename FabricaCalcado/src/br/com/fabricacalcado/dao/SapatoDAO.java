package br.com.fabricacalcado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricacalcado.model.Sapato;



public class SapatoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public SapatoDAO() {
		
	}
	
	public SapatoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Sapato sapato) {
		String sql = "insert into Sapato(tamanho, peso, nome, tipoTecido) values (?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, sapato.getTamanho());
			ps.setDouble(2, sapato.getPeso());
			ps.setString(3, sapato.getNome());
			ps.setString(4, sapato.getTipoTecido());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Sapato sapato) {
		String sql = "delete from Sapato where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, sapato.getNome());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletarSemWhere(Sapato sapato) {
		String sql = "delete from Sapato";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, sapato.getNome());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterarTamanhoSapato(Sapato sapato) {
		String sql = "update Sapato set tamanho = (?) where nome = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, sapato.getTamanho());
			ps.setString(2, sapato.getNome());
			
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Sapato> retornarDadosSapato(){
		String sql = "select * from Sapato";
		ArrayList<Sapato> retornarDadosSapato = new ArrayList<Sapato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					Sapato sapato = new Sapato();
					sapato.setTamanho(rs.getInt(1));
					sapato.setPeso(rs.getDouble(2));
					sapato.setNome(rs.getString(3));
					sapato.setTipoTecido("borracha");
					
					retornarDadosSapato.add(sapato);
				} return retornarDadosSapato;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	} 
	
	public ArrayList<Sapato> retornarDadosSapatoComWhere(){
		String sql = "select * from Sapato were nome = (?)";
		ArrayList<Sapato> retornarDadosSapato = new ArrayList<Sapato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					
					Sapato sapato = new Sapato();
					
					ps.setString(1, sapato.getNome());
							
					sapato.setTamanho(rs.getInt(1));
					sapato.setPeso(rs.getDouble(2));
					sapato.setNome(rs.getString(3));
					sapato.setTipoTecido("borracha");
					
					retornarDadosSapato.add(sapato);
				} return retornarDadosSapato;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
	
}
