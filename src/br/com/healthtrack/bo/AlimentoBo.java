package br.com.healthtrack.bo;

import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.bean.CategoriaAlimentoBean;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAlimentoDAO;

public class AlimentoBo {
	
	IAlimentoDAO dao = DAOFactory.getAlimentoDAO();
	
	List<AlimentoBean> lista;
	
	public AlimentoBean buscarAlimento (int codigoAlimento){
		
		AlimentoBean alimento = dao.buscar(codigoAlimento);
		
		return alimento;
	}
	
	public List<AlimentoBean> listarAlimento(int codigoUsuario){
		
		lista = new ArrayList<AlimentoBean>();
		lista = dao.listar(codigoUsuario);
		return lista;
		
	}
	
	public AlimentoBean inserirAlimento(int codigoUsuario, String datax, String hora, int categoriax, String ds_alimento, Double nr_caloria) {
		
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
		Calendar dt_alimento = Calendar.getInstance();
		String dataCompleta = dataFormatada + " " + hora + ":00";
		
		try {
			data = (Date) fmt.parse(dataCompleta);
			dt_alimento.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		CategoriaAlimentoBean categoria = dao.buscarCategoria(categoriax);
		AlimentoBean alimento = new AlimentoBean(codigoUsuario, categoria, nr_caloria, ds_alimento, dt_alimento);
		
		try {
			dao.cadastrar(alimento);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
				
		return alimento;
	}
	
	public AlimentoBean editarAlimento(int codigoUsuario, String datax, String hora, int categoriax, String ds_alimento, Double nr_caloria){
		
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
		Calendar dt_alimento = Calendar.getInstance();
		String dataCompleta = dataFormatada + " " + hora + ":00";
		
		try {
			data = (Date) fmt.parse(dataCompleta);
			/*String str = fmt.format(data);   // isto faz com que mostre do jeito que você quer
*/			dt_alimento.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		CategoriaAlimentoBean categoria = dao.buscarCategoria(categoriax);
		AlimentoBean alimento = new AlimentoBean(codigoUsuario, categoria, nr_caloria, ds_alimento, dt_alimento);
		
		try {
			dao.atualizar(alimento);
		} catch (DBException e) {
			e.printStackTrace();
			return null;
		}
				
		return alimento;
	}
	
	public String excluirAlimento (int codigoAlimento){
		
		try {
			dao.remover(codigoAlimento);
			return "Removido com sucesso.";
		} catch (DBException e) {
			e.printStackTrace();
			return "Problema ao remover registro.";
		}
		
	}
	
}
