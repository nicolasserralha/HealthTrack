package br.com.healthtrack.bean;

import java.util.Calendar;

public class AlimentoBean {
	

	private int cd_alimento;
	private int cd_usuario;
	private CategoriaAlimentoBean categoria;
	private double nr_caloria;
	private String ds_alimento;
	private Calendar dt_alimento;
	
	public AlimentoBean() {
		super();
	}
	
	public AlimentoBean(int cd_alimento, int cd_usuario, CategoriaAlimentoBean categoria, double nr_caloria, String ds_alimento, Calendar dt_alimento) {
		super();
		this.cd_alimento = cd_alimento;
		this.cd_usuario = cd_usuario;
		this.categoria = categoria;
		this.nr_caloria = nr_caloria;
		this.ds_alimento = ds_alimento;
		this.dt_alimento = dt_alimento;
	}
	
	public AlimentoBean(int cd_usuario, CategoriaAlimentoBean categoria, double nr_caloria, String ds_alimento, Calendar dt_alimento) {
		super();
		this.cd_usuario = cd_usuario;
		this.categoria = categoria;
		this.nr_caloria = nr_caloria;
		this.ds_alimento = ds_alimento;
		this.dt_alimento = dt_alimento;
	}
	
	public int getCd_alimento() {
		return cd_alimento;
	}
	public void setCd_alimento(int cd_alimento) {
		this.cd_alimento = cd_alimento;
	}
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public CategoriaAlimentoBean getcategoria() {
		return categoria;
	}
	public void setcategoria(CategoriaAlimentoBean categoria) {
		this.categoria = categoria;
	}
	public double getNr_caloria() {
		return nr_caloria;
	}
	public void setNr_caloria(double nr_caloria) {
		this.nr_caloria = nr_caloria;
	}
	public String getDs_alimento() {
		return ds_alimento;
	}
	public void setDs_alimento(String ds_alimento) {
		this.ds_alimento = ds_alimento;
	}
	public Calendar getDt_alimento() {
		return dt_alimento;
	}
	public void setDt_alimento(Calendar dt_alimento) {
		this.dt_alimento = dt_alimento;
	}
}
