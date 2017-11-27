package br.com.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.com.healthtrack.bean.AlimentoBean;
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
			stmt.setInt(2, alimento.getCd_cat_alimento());
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
	public void atualizar(AlimentoBean atividade) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int codigo) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AlimentoBean buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlimentoBean> listar(int codigoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
