package br.com.healthtrack.bean;

import java.util.Calendar;

public class AtividadeBean {
	
	private int cd_atividade;
	private int cd_usuario;
	private CategoriaAtividadeBean categoria;
	private double nr_caloria;
	private String ds_atividade;
	private Calendar dt_atividade;
	
	public AtividadeBean(){
		super();
	}
	
	public AtividadeBean(int cd_atividade, int cd_usuario, CategoriaAtividadeBean categoria, double nr_caloria, String ds_atividade, Calendar dt_atividade){
		super();
		this.cd_atividade = cd_atividade;
		this.cd_usuario = cd_usuario;
		this.categoria = categoria;
		this.nr_caloria = nr_caloria;
		this.ds_atividade = ds_atividade;
		this.dt_atividade = dt_atividade;
	}
	
	public AtividadeBean(int cd_usuario, CategoriaAtividadeBean categoria, double nr_caloria, String ds_atividade, Calendar dt_atividade){
		super();
		this.cd_usuario = cd_usuario;
		this.categoria = categoria;
		this.nr_caloria = nr_caloria;
		this.ds_atividade = ds_atividade;
		this.dt_atividade = dt_atividade;
	}
	
	public int getCd_atividade() {
		return cd_atividade;
	}
	public void setCd_atividade(int cd_atividade) {
		this.cd_atividade = cd_atividade;
	}
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public CategoriaAtividadeBean getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaAtividadeBean categoria) {
		this.categoria = categoria;
	}
	public double getNr_caloria() {
		return nr_caloria;
	}
	public void setNr_caloria(double nr_caloria) {
		this.nr_caloria = nr_caloria;
	}
	public String getDs_atividade() {
		return ds_atividade;
	}
	public void setDs_atividade(String ds_atividade) {
		this.ds_atividade = ds_atividade;
	}
	public Calendar getDt_atividade() {
		return dt_atividade;
	}
	public void setDt_atividade(Calendar dt_atividade) {
		this.dt_atividade = dt_atividade;
	}
}
