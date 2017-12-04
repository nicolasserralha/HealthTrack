package br.com.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.bean.CategoriaAlimentoBean;
import br.com.healthtrack.bean.CategoriaAtividadeBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.impl.IAlimentoDAO;
import br.com.healthtrack.singleton.HealthTrackDBManager;

public class AlimentoDAO implements IAlimentoDAO {
	Connection conexao = null;
	
	@Override
	public void cadastrar(AlimentoBean alimento) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "INSERT INTO T_REL_ALIMENTO (CD_USUARIO, CD_CAT_ALIMENTO, NR_CALORIA, DS_ALIMENTO, DT_ALIMENTO) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alimento.getCd_usuario());
			stmt.setInt(2, alimento.getCd_cat_alimento().getCd_cat_alimento());
			stmt.setDouble(3, alimento.getNr_caloria());
			stmt.setString(4, alimento.getDs_alimento());
			java.sql.Date data = new java.sql.Date(alimento.getDt_alimento().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar Refeição.");
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
	public void atualizar(AlimentoBean alimento) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_REL_ALIMENTO SET CD_CAT_ALIMENTO = ?, NR_CALORIA = ?, DS_ALIMENTO = ?, DT_ALIMENTO = ? WHERE CD_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alimento.getCd_cat_alimento().getCd_cat_alimento());
			stmt.setDouble(2, alimento.getNr_caloria());
			stmt.setString(3, alimento.getDs_alimento());
			java.sql.Date data = new java.sql.Date(alimento.getDt_alimento().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, alimento.getCd_alimento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Atualizar o Registro de Refeição.");
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
			String sql = "DELETE FROM T_REL_ALIMENTO WHERE CD_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover o Registro de Refeição.");
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
	public AlimentoBean buscar(int id) {
		PreparedStatement stmt = null;
		AlimentoBean alimento = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_ALIMENTO WHERE CD_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				int cd_alimento = rs.getInt("CD_ALIMENTO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				CategoriaAlimentoBean cd_cat_alimento = buscarCategoria(rs.getInt("CD_CAT_ALIMENTO"));
				double nr_caloria = rs.getDouble("NR_CALORIA");
				String ds_alimento = rs.getString("DS_ALIMENTO");
				Calendar dt_alimento = Calendar.getInstance();
				dt_alimento.setTime(rs.getDate("DT_ALIMENTO"));
				alimento = new AlimentoBean(cd_alimento,cd_usuario,cd_cat_alimento,nr_caloria,ds_alimento,dt_alimento);
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
		return alimento;
	}

	@Override
	public List<AlimentoBean> listar(int codigoUsuario) {
		PreparedStatement stmt = null;
		AlimentoBean alimento;
		List<AlimentoBean> lista = new ArrayList<AlimentoBean>();
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_ALIMENTO WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();
			
			while (rs.next()){
				int cd_alimento = rs.getInt("CD_ALIMENTO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				CategoriaAlimentoBean cd_cat_alimento = buscarCategoria(rs.getInt("CD_CAT_ALIMENTO"));
				double nr_caloria = rs.getDouble("NR_CALORIA");
				String ds_alimento = rs.getString("DS_ALIMENTO");
				Calendar dt_alimento = Calendar.getInstance();
				java.sql.Date data = rs.getDate("DT_ALIMENTO");
				dt_alimento.setTimeInMillis(data.getTime());
				alimento = new AlimentoBean(cd_alimento,cd_usuario,cd_cat_alimento,nr_caloria,ds_alimento,dt_alimento);
				lista.add(alimento);
				alimento = null;
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

	@Override
	public CategoriaAlimentoBean buscarCategoria(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CategoriaAlimentoBean categoria = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_CAT_ALIMENTO WHERE CD_CAT_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				int cd_cat_alimento = rs.getInt("CD_CAT_ALIMENTO");
				String ds_cat_alimento = rs.getString("DS_CAT_ALIMENTO");
				categoria = new CategoriaAlimentoBean(cd_cat_alimento,ds_cat_alimento);
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
		return categoria;
	}
}
