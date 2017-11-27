package br.com.healthtrack.bo;

import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.dao.UsuarioDAO;

public class UsuarioBo {

	//public boolean insereUsuario(String nm_usuario, String dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha){
	public UsuarioBean insereUsuario(UsuarioBean usuario){	
		try {		
			//UsuarioBean usuario = new UsuarioBean(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha);
			UsuarioDAO usuarioDao = new UsuarioDAO();
			usuarioDao.insert(usuario);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
