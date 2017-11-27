package br.com.healthtrack.teste;
import br.com.healthtrack.impl.IUsuarioDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		DAOFactory dao = new DAOFactory();
		IUsuarioDAO usuarioDao = dao.getUsuarioDAO();
		UsuarioBean usuario = new UsuarioBean("ZoioGay", Calendar.getInstance(), "M", 1.84f, "email@email.com", "asdqweasdqweasdqweasdqweasdqweas");
		
		//LISTAR
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		lista = usuarioDao.listar();
		for (UsuarioBean item : lista) {
			System.out.println("Nome: " + item.getNm_usuario());
			System.out.println("");
		}
		
		
		//Buscar
		UsuarioBean usuarioSelect = new UsuarioBean();
		usuarioSelect = usuarioDao.buscar(41);
		/*usuarioSelect.setNm_usuario("ZoioViado");*/
		
		
		//Remover
		try {
			usuarioDao.remover(usuarioSelect.getCd_usuario());
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		//Atualizar novo usuario
		try {
			usuarioDao.atualizar(usuarioSelect);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Cadastrar novo usuario
		try {
			usuarioDao.cadastrar(usuario);
			System.out.println("Usuario " + usuario.getNm_usuario() + " cadastrado com sucesso");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
