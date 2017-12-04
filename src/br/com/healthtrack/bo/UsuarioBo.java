package br.com.healthtrack.bo;

import java.util.Calendar;

import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IUsuarioDAO;

public class UsuarioBo {
	
	private IUsuarioDAO dao;
	private UsuarioBean usuario;

	public UsuarioBean insereUsuario(String nm_usuario, Calendar dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha) throws DBException, Exception{
		try {
			
			dao = DAOFactory.getUsuarioDAO();
			usuario = new UsuarioBean(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha);
			
			//LEMBRAR DE VERIFICAR SE O E-MAIL JÁ EXISTE E TAMBÉM DE PEGAR O CÓDIGO DO USUARIO CADASTRADO PARA COLOCAR EM UMA SESSION
			dao.cadastrar(usuario);
			
			return usuario;
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception("Erro ao Cadastrar Usuário.");
		}
	}
	
	public int validaUsuario(String email, String senha){
		
		dao = DAOFactory.getUsuarioDAO();
		usuario = new UsuarioBean(email, senha);
		
		try {
			usuario = dao.validarUsuario(usuario);
		} catch (DBException e) {
			e.printStackTrace();
			return 0;
		}
		return usuario.getCd_usuario();
	}

	public String buscaNome(int id) {
		
		UsuarioBean nomeUsuario = dao.buscar(id);
		
		return nomeUsuario.getNm_usuario();
	}
}
