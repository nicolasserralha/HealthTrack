package br.com.healthtrack.bean;

import java.util.Calendar;

public class PressaoBean {
	
	private int cd_pressao;
	private int cd_usuario;
	private double nr_pressao_sistolica;
	private double nr_pressao_diastolica;
	private String ds_pressao;
	private Calendar dt_pressao;
	
	public PressaoBean() {
		super();
	}
	
	public PressaoBean(int cd_pressao, int cd_usuario, double nr_pressao_sistolica, double nr_pressao_diastolica, String ds_pressao, Calendar dt_pressao) {
		super();
		this.cd_pressao = cd_pressao;
		this.cd_usuario = cd_usuario;
		this.nr_pressao_sistolica = nr_pressao_sistolica;
		this.nr_pressao_diastolica = nr_pressao_diastolica;
		this.ds_pressao = ds_pressao;
		this.dt_pressao = dt_pressao;
	}
	
	public PressaoBean(int cd_usuario, double nr_pressao_sistolica, double nr_pressao_diastolica, String ds_pressao, Calendar dt_pressao) {
		super();
		this.cd_usuario = cd_usuario;
		this.nr_pressao_sistolica = nr_pressao_sistolica;
		this.nr_pressao_diastolica = nr_pressao_diastolica;
		this.ds_pressao = ds_pressao;
		this.dt_pressao = dt_pressao;
	}
	
	public int getCd_pressao() {
		return cd_pressao;
	}
	public void setCd_pressao(int cd_pressao) {
		this.cd_pressao = cd_pressao;
	}
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public double getNr_pressao_sistolica() {
		return nr_pressao_sistolica;
	}
	public void setNr_pressao_sistolica(double nr_pressao_sistolica) {
		this.nr_pressao_sistolica = nr_pressao_sistolica;
	}
	public double getNr_pressao_diastolica() {
		return nr_pressao_diastolica;
	}
	public void setNr_pressao_diastolica(double nr_pressao_diastolica) {
		this.nr_pressao_diastolica = nr_pressao_diastolica;
	}
	public String getDs_pressao() {
		return ds_pressao;
	}
	public void setDs_pressao(String ds_pressao) {
		this.ds_pressao = ds_pressao;
	}
	public Calendar getDt_pressao() {
		return dt_pressao;
	}
	public void setDt_pressao(Calendar dt_pressao) {
		this.dt_pressao = dt_pressao;
	}

}
