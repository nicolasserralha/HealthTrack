package br.com.healthtrack.bo;

import java.util.Calendar;

import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IUsuarioDAO;

public class UsuarioBo {
	
	private IUsuarioDAO dao;
	private UsuarioBean usuario;

	public UsuarioBean insereUsuario(String nm_usuario, Calendar dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha){
		try {
			
			dao = DAOFactory.getUsuarioDAO();
			usuario = new UsuarioBean(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha);
			
			//LEMBRAR DE VERIFICAR SE O E-MAIL J� EXISTE E TAMB�M DE PEGAR O C�DIGO DO USUARIO CADASTRADO PARA COLOCAR EM UMA SESSION
			dao.cadastrar(usuario);
			
			return usuario;
			
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
