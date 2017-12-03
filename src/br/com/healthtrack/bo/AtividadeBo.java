package br.com.healthtrack.bo;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.bean.CategoriaAtividadeBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAtividadeDAO;

public class AtividadeBo {
	
	IAtividadeDAO dao = DAOFactory.getAtividadeDAO();
	
	List<AtividadeBean> lista;
	
	
	public List<AtividadeBean> listarAtividade(int codigoUsuario){
		
		lista = new ArrayList<AtividadeBean>();
		lista = dao.listar(codigoUsuario);
		return lista;
		
	}
	
	public AtividadeBean inserirAtividade(int codigoUsuario, String datax, String hora, int categoriax, String ds_atividade, Double nr_caloria) {
		Date data;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
		Calendar dt_atividade = Calendar.getInstance();
		
		try {
			data = (Date) fmt.parse(datax + hora);
			String str = fmt.format(data);   // isto faz com que mostre do jeito que você quer
			dt_atividade.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		CategoriaAtividadeBean categoria = dao.buscarCategoria(categoriax);
		AtividadeBean atividade = new AtividadeBean(codigoUsuario, categoria, nr_caloria, ds_atividade, dt_atividade);
		
		try {
			dao.cadastrar(atividade);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
				
		return atividade;
	}
	
	public AtividadeBean editarAtividade(int codigoUsuario, String datax, String hora, int categoriax, String ds_atividade, Double nr_caloria){
		Date data;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
		Calendar dt_atividade = Calendar.getInstance();
		
		try {
			data = (Date) fmt.parse(datax + hora);
			String str = fmt.format(data);   // isto faz com que mostre do jeito que você quer
			dt_atividade.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		CategoriaAtividadeBean categoria = dao.buscarCategoria(categoriax);
		AtividadeBean atividade = new AtividadeBean(codigoUsuario, categoria, nr_caloria, ds_atividade, dt_atividade);
		
		try {
			dao.atualizar(atividade);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		return atividade;
	}
	
	public String excluirAtividade (int codigoAtividade){
		
		try {
			dao.remover(codigoAtividade);
			return "Removido com sucesso.";
		} catch (DBException e) {
			e.printStackTrace();
			return "Problema ao remover registro.";
		}
		
	}
	
	
	
	
	
	
}
