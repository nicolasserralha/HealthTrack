package br.com.healthtrack.teste;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.PesoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IPesoDAO;

public class PesoDAOTeste {

	public static void main(String[] args) {
		
		IPesoDAO dao = DAOFactory.getPesoDAO();
		
		//LISTAR POR CODIGO DE USUARIO
		List<PesoBean> listaPeso = new ArrayList<PesoBean>();
		listaPeso = dao.listar(1);
		for (PesoBean item : listaPeso) {
			System.out.println("Código do Usuário: " + item.getCd_usuario());
			System.out.println("Peso: " + item.getNr_peso());
			System.out.println("Descrição: " + item.getDs_peso());
			System.out.println("-------------------------------------");
			System.out.println("");
		}
		
		
		try {
			PesoBean pesoBean2 = new PesoBean(101,502,80,"PESO ATUALIZADO", Calendar.getInstance());
			dao.atualizar(pesoBean2);
			System.out.println("Código do Usuário: " + pesoBean2.getCd_usuario());
			System.out.println("Peso: " + pesoBean2.getNr_peso());
			System.out.println("Descrição: " + pesoBean2.getDs_peso());	
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//CADASTRAR PESO
		try {
			PesoBean pesoTeste = new PesoBean(502,80,"teste", Calendar.getInstance());
			dao.cadastrar(pesoTeste);
			System.out.println("O Peso foi cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}
		//----------------
	
		//BUSCAR POR CODIGO DE PESO
		PesoBean pesoBean = new PesoBean();
		pesoBean = dao.buscar(101);
		System.out.println("O Registro foi selecionado.");
		System.out.println("Código do Usuário: " + pesoBean.getCd_usuario());
		System.out.println("Peso: " + pesoBean.getNr_peso());
		System.out.println("Descrição: " + pesoBean.getDs_peso());
		//----------------
		

	}
}
