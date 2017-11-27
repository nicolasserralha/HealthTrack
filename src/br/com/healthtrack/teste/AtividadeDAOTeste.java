package br.com.healthtrack.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAtividadeDAO;


public class AtividadeDAOTeste {
	public static void main(String[] args) {
		
		IAtividadeDAO atividadeDao = DAOFactory.getAtividadeDAO();
		AtividadeBean atividade = new AtividadeBean();
		List<AtividadeBean> lista = new ArrayList<AtividadeBean>();
		
		//Cadastrar nova atividade
		try {
			atividade.setCd_cat_atividade(1);
			atividade.setCd_usuario(1);
			atividade.setDs_atividade("corrida");
			atividade.setDt_atividade(Calendar.getInstance());
			atividade.setNr_caloria(200);
			atividadeDao.cadastrar(atividade);
			System.out.println("Atividade de código: " + atividade.getCd_atividade() + " cadastrado com sucesso");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//LISTAR
		lista = atividadeDao.listar(1);
		for (AtividadeBean item : lista) {
			System.out.println("Calorias: " + item.getNr_caloria());
			System.out.println("");
		}
		
		//Buscar
		AtividadeBean atividadeAtualizar = new AtividadeBean();
		atividadeAtualizar = atividadeDao.buscar(8);
		
		//Remover
		try {
			atividadeDao.remover(atividadeAtualizar.getCd_atividade());
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		
		//Atualizar novo usuario
		try {
			atividadeAtualizar.setNr_caloria(300);
			atividadeDao.atualizar(atividadeAtualizar);
		} catch (DBException e) {
			e.printStackTrace();
		}
		


		
		
		
		//LISTAR
/*		List<AtividadeBean> lista = new ArrayList<AtividadeBean>();
		lista = atividadeDao.listar();
		for (AtividadeBean item : lista) {
			System.out.println("Nome: " + item.getCd_atividade());
			System.out.println("");
		}*/

	}
}

		/*
		//Buscar
		UsuarioBean usuarioSelect = new UsuarioBean();
		usuarioSelect = usuarioDao.buscar(41);
		usuarioSelect.setNm_usuario("ZoioViado");
		
		
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
		
		

		
	}*/

