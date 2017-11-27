package br.com.healthtrack.factory;

import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.impl.IAtividadeDAO;
import br.com.healthtrack.impl.IPesoDAO;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.impl.IUsuarioDAO;


public class DAOFactory {

	public static IPesoDAO getPesoDAO() {
		return new PesoDAO();
	}
  
	public static IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	public IAtividadeDAO getAtividadeDAO() {
		return new AtividadeDAO();
	}
  
}