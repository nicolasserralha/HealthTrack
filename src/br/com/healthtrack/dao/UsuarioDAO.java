package br.com.healthtrack.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.impl.IUsuarioDAO;
import br.com.healthtrack.singleton.HealthTrackDBManager;

public class UsuarioDAO implements IUsuarioDAO{
	
	private Connection conexao = null;
	
	@Override
	public void cadastrar(UsuarioBean usuario) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "INSERT INTO T_USUARIO (NM_USUARIO, DT_NASCIMENTO, DS_SEXO, NR_ALTURA, DS_EMAIL, DS_SENHA, ATIVO) VALUES (?, ?, ?, ?, ?, ?, 1)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNm_usuario());
			java.sql.Date data = new java.sql.Date(usuario.getDt_nascimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setString(3, usuario.getDs_sexo());
			stmt.setFloat(4, usuario.getNr_altura());
			stmt.setString(5, usuario.getDs_email());
			stmt.setString(6, usuario.getDs_senha());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar Usuário.");
		} finally {
			try {
				conexao.close();
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(UsuarioBean usuario) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_USUARIO SET NM_USUARIO = ?, DT_NASCIMENTO = ?, DS_SEXO = ?, NR_ALTURA = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNm_usuario());
			java.sql.Date data = new java.sql.Date(usuario.getDt_nascimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setString(3, usuario.getDs_sexo());
			stmt.setFloat(4, usuario.getNr_altura());
			stmt.setString(5, usuario.getDs_email());
			stmt.setString(6, usuario.getDs_senha());
			stmt.setInt(7, usuario.getCd_usuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Atualizar o Usuario.");
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
	public void desativarUsuario(UsuarioBean usuario) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "UPDATE T_USUARIO SET ATIVO = 0 WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCd_usuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Desativar o Usuario.");
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
			String sql = "DELETE FROM T_USUARIO WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Remover o Usuario.");
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
	public UsuarioBean buscar(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_USUARIO WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				
			
			int codigo = rs.getInt("CD_USUARIO");
			String nome = rs.getString("NM_USUARIO");
			Calendar dt_nascimento = Calendar.getInstance();
			dt_nascimento.setTime(rs.getDate("DT_NASCIMENTO"));
			float altura = rs.getFloat("NR_ALTURA");
			String sexo = rs.getString("DS_SEXO");
			String email = rs.getString("DS_EMAIL");
			String senha = rs.getString("DS_SENHA");
			
			usuario = new UsuarioBean(codigo, nome, dt_nascimento, sexo, altura, email, senha);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				stmt.close();
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usuario;
	}
	
	@Override
	public List<UsuarioBean> listar() {
		PreparedStatement stmt = null;
		UsuarioBean usuario = null;
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		ResultSet rs = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_USUARIO";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				int codigo = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_USUARIO");
				Calendar dt_nascimento = Calendar.getInstance();
				dt_nascimento.setTime(rs.getDate("DT_NASCIMENTO"));
				float altura = rs.getFloat("NR_ALTURA");
				String sexo = rs.getString("DS_SEXO");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("DS_SENHA");
				usuario = new UsuarioBean(codigo, nome, dt_nascimento, sexo, altura, email, senha);
				lista.add(usuario);
				usuario = null;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	
	
	@Override
	public UsuarioBean validarUsuario(UsuarioBean usuario) throws DBException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = HealthTrackDBManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_USUARIO WHERE DS_EMAIL = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getDs_email());
			rs = stmt.executeQuery();
			
			if(rs.next()){
			
			int codigo = rs.getInt("CD_USUARIO");
			String nome = rs.getString("NM_USUARIO");
			Calendar dt_nascimento = Calendar.getInstance();
			dt_nascimento.setTime(rs.getDate("DT_NASCIMENTO"));
			float altura = rs.getFloat("NR_ALTURA");
			String sexo = rs.getString("DS_SEXO");
			String email = rs.getString("DS_EMAIL");
			String senha = rs.getString("DS_SENHA");
			
			usuario = new UsuarioBean(codigo, nome, dt_nascimento, sexo, altura, email, senha);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				stmt.close();
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usuario;

	}

}
		