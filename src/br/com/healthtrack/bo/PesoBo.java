package br.com.healthtrack.bo;

import java.util.ArrayList;

import br.com.healthtrack.bean.PesoBean;
import br.com.healthtrack.dao.PesoDAO;

public class PesoBo {

	public PesoBean popularObjeto(int cd_usuario, double nr_peso, String ds_peso, String dt_peso){	
		try {		
			PesoBean peso = new PesoBean();
			peso.setCd_usuario(cd_usuario); //usuario
			peso.setNr_peso(nr_peso);
			peso.setDs_peso(ds_peso);
			/*peso.setDt_peso(dt_peso);*/
			return peso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PesoBean inserePeso(PesoBean peso){	
		try {		
			PesoDAO pesoDao = new PesoDAO();
			/*pesoDao.insert(peso);*/
			return peso;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public ArrayList<PesoBean> listaPeso(){	
		ArrayList<PesoBean> lista = new ArrayList<PesoBean>();
		try {		
			PesoDAO pesoDao = new PesoDAO();
			/*lista = pesoDao.getAll();*/
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
