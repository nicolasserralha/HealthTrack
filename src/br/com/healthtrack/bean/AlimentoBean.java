package br.com.healthtrack.bean;

import java.util.Calendar;

public class AlimentoBean {
	
	private int cd_alimento;
	private int cd_usuario;
	private int cd_cat_alimento;
	private double nr_caloria;
	private String ds_alimento;
	private Calendar dt_alimento;
	
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
	public int getCd_cat_alimento() {
		return cd_cat_alimento;
	}
	public void setCd_cat_alimento(int cd_cat_alimento) {
		this.cd_cat_alimento = cd_cat_alimento;
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
