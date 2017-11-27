package br.com.healthtrack.factory;

import br.com.healthtrack.dao.AlimentoDAO;
import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.impl.IAlimentoDAO;
import br.com.healthtrack.impl.IAtividadeDAO;
import br.com.healthtrack.impl.IPesoDAO;
import br.com.healthtrack.impl.IPressaoDAO;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.impl.IUsuarioDAO;


public class DAOFactory {

	public static IPesoDAO getPesoDAO() {
		return new PesoDAO();
	}
  
	public static IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	public static IAtividadeDAO getAtividadeDAO() {
		return new AtividadeDAO();
	}
  
	public static IAlimentoDAO getAlimentoDAO() {
		return new AlimentoDAO();
	}
	
	public static IPressaoDAO getPressaoDAO() {
		return new PressaoDAO();
	}
}