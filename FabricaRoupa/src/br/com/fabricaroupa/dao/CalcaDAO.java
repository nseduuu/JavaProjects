package br.com.fabricaroupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricaroupa.model.Calca;

public class CalcaDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CalcaDAO() {

	}

	public CalcaDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Calca calca) {
		String sql = "insert into Calca(peso, tipoTecido, tipo) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, calca.getPeso());
			ps.setString(2, calca.getTipoTecido());
		    ps.setString(3, calca.getTipo());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
		
	}

	public String deletar(Calca calca) {
		String sql = "delete from Calca where peso = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, calca.getPeso());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String deletarSemWhere(Calca calca) {
		String sql = "delete from Calca";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, calca.getPeso());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterarPesoCalca(Calca calca) {
		String sql = "update Calca set peso = (?) where tipoTecido = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, calca.getPeso());
			ps.setString(2, calca.getTipoTecido());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Calca> retornarDadosCalca() {
		String sql = "select * from Calca";
		ArrayList<Calca> retornarDadosCalca = new ArrayList<Calca>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Calca calca = new Calca();

					calca.setPeso(rs.getDouble(1));
					calca.setTipoTecido(rs.getString(2));
					calca.setTipo(rs.getString(3));

					retornarDadosCalca.add(calca);
				}
				return retornarDadosCalca;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Calca> retornarDadosCalcaComWhere(String tipo) {
		String sql = "select * from Calca where tipo = (?)";
		ArrayList<Calca> retornarDadosBlusaComWhere = new ArrayList<Calca>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Calca calcaSearch = new Calca();
					calcaSearch.setPeso(rs.getDouble(1));
					calcaSearch.setTipoTecido(rs.getString(2));
					calcaSearch.setTipo(rs.getString(3));

					retornarDadosBlusaComWhere.add(calcaSearch);
				}
				return retornarDadosBlusaComWhere;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
