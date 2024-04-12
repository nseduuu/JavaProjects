package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Endereco;

public class EnderecoDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAO() {

	}

	public EnderecoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Endereco endereco) {

		String sql = "insert into Endereco(cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, endereco.getCep());
			ps.setString(2, endereco.getLogradouro());
		    ps.setString(3, endereco.getComplemento());
		    ps.setString(4, endereco.getBairro());
		    ps.setString(5, endereco.getLocalidade());
		    ps.setString(6, endereco.getUf());
		    ps.setString(7, endereco.getIbge());
		    ps.setString(8, endereco.getGia());
		    ps.setString(9, endereco.getDdd());
		    ps.setString(10, endereco.getSiafi());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}	
		
	}
}