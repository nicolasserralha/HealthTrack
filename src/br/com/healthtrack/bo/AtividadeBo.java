package br.com.healthtrack.bo;

import java.util.Date;
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
	
	public AtividadeBean buscarAtividade (int codigoAtividade){
		
		AtividadeBean atividade = dao.buscar(codigoAtividade);
		
		return atividade;
	}
	
	public List<AtividadeBean> listarAtividade(int codigoUsuario){
		
		lista = new ArrayList<AtividadeBean>();
		lista = dao.listar(codigoUsuario);
		return lista;
		
	}
	
	public AtividadeBean inserirAtividade(int codigoUsuario, String datax, String hora, int categoriax, String ds_atividade, Double nr_caloria) {
		
		String dataFormatada = "";
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date dataf = (Date) formato.parse(datax);
			formato.applyPattern("dd/MM/yyyy");
			dataFormatada = formato.format(dataf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Date data;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
		Calendar dt_atividade = Calendar.getInstance();
		String dataCompleta = dataFormatada + " " + hora + ":00";
		
		try {
			data = (Date) fmt.parse(dataCompleta);
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
		
		String dataFormatada = "";
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date dataf = (Date) formato.parse(datax);
			formato.applyPattern("dd/MM/yyyy");
			dataFormatada = formato.format(dataf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Date data;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
		Calendar dt_atividade = Calendar.getInstance();
		String dataCompleta = dataFormatada + " " + hora + ":00";
		
		try {
			data = (Date) fmt.parse(dataCompleta);
			/*String str = fmt.format(data);   // isto faz com que mostre do jeito que você quer
*/			dt_atividade.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		CategoriaAtividadeBean categoria = dao.buscarCategoria(categoriax);
		AtividadeBean atividade = new AtividadeBean(codigoUsuario, categoria, nr_caloria, ds_atividade, dt_atividade);
		
		try {
			dao.atualizar(atividade);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
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
