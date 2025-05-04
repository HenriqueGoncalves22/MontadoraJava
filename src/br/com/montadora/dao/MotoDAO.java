package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.montadora.model.Moto;

public class MotoDAO {
	
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public MotoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Moto moto) {
		String sql = "insert into moto(montadora, nome, quantidadeadesivos) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getNome());
			ps.setInt(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto inserida com sucesso";
			} else {
				return "Erro ao inserir moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Moto moto) {
		String sql = "delete from moto where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getNome());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deleta moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Moto moto) {
		String sql = "update moto set nome = ? where montadora = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getNome());
			ps.setString(2,  moto.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Moto Atualizada com sucesso";
			} else {
				return "Erro atualizar a moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public ArrayList<Moto> retornarDados()
	{
		String sql = "select * from moto";
		ArrayList<Moto> retornarMoto = new ArrayList<Moto>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
				    Moto moto = new Moto();
					moto.setMontadora(rs.getString(1));
					moto.setNome(rs.getString(2));
					moto.setQuantidadeAdesivos(rs.getInt(3));
					retornarMoto.add(moto);
				}
				return retornarMoto;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
		
	}

}




