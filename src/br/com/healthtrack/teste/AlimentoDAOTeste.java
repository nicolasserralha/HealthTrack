package br.com.healthtrack.teste;

import java.util.Calendar;

import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAlimentoDAO;

public class AlimentoDAOTeste {

	public static void main(String[] args) {
		
		IAlimentoDAO dao = DAOFactory.getAlimentoDAO();
		AlimentoBean alimento = new AlimentoBean();
		
		//cadastrar
		try {
			alimento.setCd_cat_alimento(1);
			alimento.setCd_usuario(1);
			alimento.setDs_alimento("corrida");
			alimento.setDt_alimento(Calendar.getInstance());
			alimento.setNr_caloria(200);
			dao.cadastrar(alimento);
			System.out.println("ALIMENTO CADASTRADO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
