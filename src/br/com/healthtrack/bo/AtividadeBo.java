package br.com.healthtrack.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAtividadeDAO;

public class AtividadeBo {
	
	
	public List<AtividadeBean> listarAtividade(int codigoUsuario){
		IAtividadeDAO dao = DAOFactory.getAtividadeDAO();
		List<AtividadeBean> lista = new ArrayList<AtividadeBean>();
		
		lista = dao.listar(codigoUsuario);
		
		return lista;
		
	}
	
	
	
	
	
}
