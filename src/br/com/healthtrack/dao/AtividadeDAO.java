package br.com.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.bean.CategoriaAtividadeBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.impl.IAtividadeDAO;
import br.com.healthtrack.singleton.HealthTrackDBManager;

public class AtividadeDAO implements IAtividadeDAO{
	Connection conexao = null;
	
	@Override
	public void cadastrar(AtividadeBean atividade) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "INSERT INTO T_REL_ATIVIDADE (CD_USUARIO, CD_CAT_ATIVIDADE, NR_CALORIA, DS_ATIVIDADE, DT_ATIVIDADE) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getCd_usuario());
			stmt.setInt(2, atividade.getCategoria().getCd_cat_atividade());
			stmt.setDouble(3, atividade.getNr_caloria());
			stmt.setString(4, atividade.getDs_atividade());
			java.sql.Date data = new java.sql.Date(atividade.getDt_atividade().getTimeInMillis());
			stmt.setDate(5, data);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar Atividade.");
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
	public void atualizar(AtividadeBean atividade) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_REL_ATIVIDADE SET CD_CAT_ATIVIDADE = ?, NR_CALORIA = ?, DS_ATIVIDADE = ?, DT_ATIVIDADE = ? WHERE CD_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getCategoria().getCd_cat_atividade());
			stmt.setDouble(2, atividade.getNr_caloria());
			stmt.setString(3, atividade.getDs_atividade());
			java.sql.Date data = new java.sql.Date(atividade.getDt_atividade().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setInt(5, atividade.getCd_atividade());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Atualizar o Registro de Atividade.");
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
			String sql = "DELETE FROM T_REL_ATIVIDADE WHERE CD_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover o Registro de Atividade.");
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
	public AtividadeBean buscar(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AtividadeBean atividade = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_ATIVIDADE WHERE CD_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				int cd_atividade = rs.getInt("CD_ATIVIDADE");
				int cd_usuario = rs.getInt("CD_USUARIO");
				CategoriaAtividadeBean cd_cat_atividade = buscarCategoria(rs.getInt("CD_CAT_ATIVIDADE"));
				double nr_caloria = rs.getDouble("NR_CALORIA");
				String ds_atividade = rs.getString("DS_ATIVIDADE");
				java.sql.Date data = rs.getDate("DT_ATIVIDADE");
				Calendar dt_atividade = Calendar.getInstance();
				dt_atividade.setTimeInMillis(data.getTime());
				atividade = new AtividadeBean(cd_atividade,cd_usuario,cd_cat_atividade,nr_caloria,ds_atividade,dt_atividade);
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
		return atividade;
	}

	@Override
	public List<AtividadeBean> listar(int codigoUsuario){
		PreparedStatement stmt = null;
		AtividadeBean atividade;
		List<AtividadeBean> lista = new ArrayList<AtividadeBean>();
		
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_ATIVIDADE WHERE CD_USUARIO = ? order by DT_ATIVIDADE DESC";
			stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, codigoUsuario);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				int cd_atividade = rs.getInt("CD_ATIVIDADE");
				int cd_usuario = rs.getInt("CD_USUARIO");
				CategoriaAtividadeBean cd_cat_atividade = buscarCategoria(rs.getInt("CD_CAT_ATIVIDADE"));
				double nr_caloria = rs.getDouble("NR_CALORIA");
				String ds_atividade = rs.getString("DS_ATIVIDADE");
				Calendar dt_atividade = Calendar.getInstance();
				java.sql.Date data = rs.getDate("DT_ATIVIDADE");
				dt_atividade.setTimeInMillis(data.getTime());
				atividade = new AtividadeBean(cd_atividade,cd_usuario,cd_cat_atividade,nr_caloria,ds_atividade,dt_atividade);
				lista.add(atividade);
				atividade = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	@Override
	public CategoriaAtividadeBean buscarCategoria(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CategoriaAtividadeBean categoria = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_CAT_ATIVIDADE WHERE CD_CAT_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				int cd_cat_atividade = rs.getInt("CD_CAT_ATIVIDADE");
				String ds_cat_atividade = rs.getString("DS_CAT_ATIVIDADE");
				categoria = new CategoriaAtividadeBean(cd_cat_atividade,ds_cat_atividade);
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
		
