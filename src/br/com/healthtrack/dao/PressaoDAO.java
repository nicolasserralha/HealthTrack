package br.com.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.PressaoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.impl.IPressaoDAO;
import br.com.healthtrack.singleton.HealthTrackDBManager;

public class PressaoDAO implements IPressaoDAO{
	Connection conexao = null;
	
	@Override
	public void cadastrar(PressaoBean pressao) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "INSERT INTO T_REL_PRESSAO (CD_USUARIO, NR_PRESSAO_SISTOLICA, NR_PRESSAO_DIASTOLICA, DS_PRESSAO, DT_PRESSAO) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getCd_usuario());
			stmt.setDouble(2, pressao.getNr_pressao_sistolica());
			stmt.setDouble(3, pressao.getNr_pressao_diastolica());
			stmt.setString(4, pressao.getDs_pressao());
			java.sql.Date data = new java.sql.Date(pressao.getDt_pressao().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar Pressão.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(PressaoBean pressao) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_REL_PRESSAO SET NR_PRESSAO_SISTOLICA = ?, NR_PRESSAO_DIASTOLICA = ?, DS_PRESSAO = ?, DT_PRESSAO = ? WHERE CD_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, pressao.getNr_pressao_sistolica());
			stmt.setDouble(2, pressao.getNr_pressao_diastolica());
			stmt.setString(3, pressao.getDs_pressao());
			java.sql.Date data = new java.sql.Date(pressao.getDt_pressao().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, pressao.getCd_pressao());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Atualizar o Registro de Pressão.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}		
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "DELETE FROM T_REL_PRESSAO WHERE CD_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover o Registro de Pressão.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public PressaoBean buscar(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PressaoBean pressao = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_PRESSAO WHERE CD_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				int cd_pressao = rs.getInt("CD_PRESSAO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				double nr_pressao_sistolica = rs.getDouble("NR_PRESSAO_SISTOLICA");
				double nr_pressao_diastolica = rs.getDouble("NR_PRESSAO_DIASTOLICA");
				String ds_pressao = rs.getString("DS_PRESSAO");
				Calendar dt_pressao = Calendar.getInstance();
				dt_pressao.setTime(rs.getDate("DT_PRESSAO"));
				pressao = new PressaoBean(cd_pressao,cd_usuario,nr_pressao_sistolica,nr_pressao_diastolica,ds_pressao,dt_pressao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				rs.close();
				stmt.close();
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return pressao;
	}

	@Override
	public List<PressaoBean> listar(int codigoUsuario) {
		PreparedStatement stmt = null;
		PressaoBean pressao;
		List<PressaoBean> lista = new ArrayList<PressaoBean>();
		ResultSet rs = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_PRESSAO WHERE CD_USUARIO = ? order by DT_PRESSAO DESC";
			stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();

			while (rs.next()){
				int cd_pressao = rs.getInt("CD_PRESSAO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				int nr_pressao_sistolica = rs.getInt("NR_PRESSAO_SISTOLICA");
				double nr_pressao_diastolica = rs.getDouble("NR_PRESSAO_DIASTOLICA");
				String ds_pressao = rs.getString("DS_PRESSAO");
				Calendar dt_pressao = Calendar.getInstance();
				java.sql.Date data = rs.getDate("DT_PRESSAO");
				dt_pressao.setTimeInMillis(data.getTime());
				pressao = new PressaoBean(cd_pressao,cd_usuario,nr_pressao_sistolica,nr_pressao_diastolica,ds_pressao,dt_pressao);
				lista.add(pressao);
				pressao = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
