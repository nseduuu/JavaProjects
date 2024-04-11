package br.com.fabricaroupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricaroupa.model.Blusa;

public class BlusaDAO {

	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public BlusaDAO() {

	}

	public BlusaDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Blusa blusa) {
		String sql = "insert into Blusa(peso, tipoTecido, touca) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, blusa.getPeso());
			ps.setString(2, blusa.getTipoTecido());
		    ps.setString(3, blusa.getTouca());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String deletar(Blusa blusa) {
		String sql = "delete from Blusa where peso = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, blusa.getPeso());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String deletarSemWhere(Blusa blusa) {
		String sql = "delete from Blusa";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(1, blusa.getPeso());
			if (ps.executeUpdate() > 0) {
				return "Delatado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterarTamanhoBlusa(Blusa blusa) {
		String sql = "update Blusa set peso = (?) where tipoTecido = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, blusa.getPeso());
			ps.setString(2, blusa.getTipoTecido());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Blusa> retornarDadosBlusa() {
		String sql = "select * from Blusa";
		ArrayList<Blusa> retornarDadosBlusa = new ArrayList<Blusa>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Blusa blusa = new Blusa();

					blusa.setPeso(rs.getDouble(1));
					blusa.setTipoTecido(rs.getString(2));
					blusa.setTouca(rs.getString(3));

					retornarDadosBlusa.add(blusa);
				}
				return retornarDadosBlusa;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Blusa> retornarDadosBlusaComWhere(double peso) {
		String sql = "select * from Blusa where peso = (?)";
		ArrayList<Blusa> retornarDadosBlusaComWhere = new ArrayList<Blusa>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, peso);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Blusa blusaSearch = new Blusa();
					blusaSearch.setPeso(rs.getDouble(1));
					blusaSearch.setTipoTecido(rs.getString(2));
					blusaSearch.setTouca(rs.getString(3));

					retornarDadosBlusaComWhere.add(blusaSearch);
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
