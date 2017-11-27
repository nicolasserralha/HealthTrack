package br.com.healthtrack.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.PressaoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IPressaoDAO;

public class PressaoDAOTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IPressaoDAO dao = DAOFactory.getPressaoDAO(); 
		PressaoBean pressao = new PressaoBean(1, 120, 80, "normal", Calendar.getInstance());
		PressaoBean pressaoAtualizar = null;
		List<PressaoBean> lista = new ArrayList<PressaoBean>();
		
		//listar
		lista = dao.listar(1);
		for (PressaoBean item : lista) {
			System.out.println(item.getDs_pressao());	
		}
		
		//buscar
		pressaoAtualizar = dao.buscar(10);
		
		//atualizar
		try {
			pressaoAtualizar.setDs_pressao("pressao atualizada");
			dao.atualizar(pressaoAtualizar);
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		//cadastrar
		try {
			dao.cadastrar(pressao);
			System.out.println("Cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
}
