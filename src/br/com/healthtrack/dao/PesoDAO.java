package br.com.healthtrack.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.PesoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.impl.IPesoDAO;
import br.com.healthtrack.singleton.HealthTrackDBManager;

public class PesoDAO implements IPesoDAO {
	
	private Connection conexao = null;
	
	@Override
	public void cadastrar(PesoBean peso) throws DBException{ //pegar as excecoes certas que podem ocorrer e especificar no lugar de exception
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "INSERT INTO T_REL_PESO (CD_USUARIO, NR_PESO, DS_PESO, DT_PESO) VALUES (?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, peso.getCd_usuario());
			stmt.setDouble(2, peso.getNr_peso());
			stmt.setString(3, peso.getDs_peso());
			java.sql.Date data = new java.sql.Date(peso.getDt_peso().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar;");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void atualizar(PesoBean peso) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_REL_PESO SET NR_PESO = ?, DS_PESO = ?, DT_PESO = ? WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, peso.getNr_peso());
			stmt.setString(2, peso.getDs_peso());
			java.sql.Date data = new java.sql.Date(peso.getDt_peso().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, peso.getCd_peso());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Atualizar;");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "DELETE T_REL_PESO WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover;");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public PesoBean buscar(int id) {
		PreparedStatement stmt = null;
		PesoBean peso = null;
		ResultSet rs = null; //vamos utilizar o método next() do ResultSet para verificar se retornou algum valor, se sim, preencheremos um objeto de PesoBean para retornar

		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_PESO WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				int cd_peso = rs.getInt("CD_PESO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				double nr_peso = rs.getDouble("NR_PESO");
				String ds_peso = rs.getString("DS_PESO");
				java.sql.Date data = rs.getDate("DT_PESO");
 				Calendar dt_peso = Calendar.getInstance();
				dt_peso.setTimeInMillis(data.getTime());
				peso = new PesoBean(cd_peso, cd_usuario, nr_peso, ds_peso, dt_peso);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return peso;
	}
		
	@Override
	public List<PesoBean> listar(int codigoUsuario){
		PreparedStatement stmt = null;
		PesoBean peso;
		List<PesoBean> listaPeso = new ArrayList<PesoBean>();
		
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_REL_PESO WHERE CD_USUARIO = ? order by DT_ATIVIDADE DESC";
			stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, codigoUsuario);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				int cd_peso = rs.getInt("CD_PESO");
				int cd_usuario = rs.getInt("CD_USUARIO");
				double nr_peso = rs.getDouble("NR_PESO");
				String ds_peso = rs.getString("DS_PESO");
				java.sql.Date data = rs.getDate("DT_PESO");
 				Calendar dt_peso = Calendar.getInstance();
				dt_peso.setTimeInMillis(data.getTime());
				peso = new PesoBean(cd_peso, cd_usuario, nr_peso, ds_peso, dt_peso);
				listaPeso.add(peso);
                peso = null;
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
		return listaPeso;
	}

}