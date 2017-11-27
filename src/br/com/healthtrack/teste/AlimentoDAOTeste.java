package br.com.healthtrack.teste;

import java.util.Calendar;

import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAlimentoDAO;

public class AlimentoDAOTeste {

	public static void main(String[] args) {
		
		IAlimentoDAO dao = DAOFactory.getAlimentoDAO();
		AlimentoBean alimento = new AlimentoBean(1,1,258,"teste desc", Calendar.getInstance());
		
		//cadastrar
		try {
			dao.cadastrar(alimento);
			System.out.println("ALIMENTO CADASTRADO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
