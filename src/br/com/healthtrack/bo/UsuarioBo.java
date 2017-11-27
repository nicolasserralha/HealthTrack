package br.com.healthtrack.bo;

import java.util.Calendar;

import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.dao.UsuarioDAO;

public class UsuarioBo {

	public UsuarioBean insereUsuario(String nm_usuario, Calendar dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha){
		try {
			UsuarioDAO dao = new UsuarioDAO();
			UsuarioBean usuario = new UsuarioBean(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha);
			dao.cadastrar(usuario);
			
			return usuario;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
