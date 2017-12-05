package br.com.healthtrack.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAlimentoDAO;

public class AlimentoDAOTeste {

	public static void main(String[] args) {
		
 		IAlimentoDAO dao = DAOFactory.getAlimentoDAO();
		AlimentoBean alimento = new AlimentoBean();
		AlimentoBean alimentoBuscar = null;
		List<AlimentoBean> lista = new ArrayList<AlimentoBean>();
		
		//listar
		lista = dao.listar(1);
		for (AlimentoBean item : lista) {
			System.out.println(item.getDs_alimento());
		}
		
		//buscar
		alimentoBuscar = dao.buscar(3);
		System.out.println(alimentoBuscar.getDs_alimento());
		
		//excluir
		try {
			dao.remover(2);
			System.out.println("registro removido");
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		//cadastrar
		try {
			/*alimento.setCd_cat_alimento(2);*/
			alimento.setCd_usuario(1);
			alimento.setDs_alimento("blablaslealsda");
			alimento.setDt_alimento(Calendar.getInstance());
			alimento.setNr_caloria(400);
			dao.cadastrar(alimento);
			System.out.println("ALIMENTO CADASTRADO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
