package br.com.healthtrack.bean;

import java.util.Calendar;

public class PesoBean {
	
	private int cd_peso;
	private int cd_usuario;
	private double nr_peso;
	private String ds_peso;
	private Calendar dt_peso;
	
	public PesoBean(){
		super();
	}
	
	public PesoBean(int cd_peso, int cd_usuario, double nr_peso, String ds_peso, Calendar dt_peso){
		super();
		this.cd_peso = cd_peso;
		this.cd_usuario = cd_usuario;
		this.nr_peso = nr_peso;
		this.ds_peso = ds_peso;
		this.dt_peso = dt_peso;
	}
	
	public PesoBean(int cd_usuario, double nr_peso, String ds_peso, Calendar dt_peso){
		super();
		this.cd_usuario = cd_usuario;
		this.nr_peso = nr_peso;
		this.ds_peso = ds_peso;
		this.dt_peso = dt_peso;
	}
	
	public int getCd_peso() {
		return cd_peso;
	}
	public void setCd_peso(int cd_peso) {
		this.cd_peso = cd_peso;
	}
	public double getNr_peso() {
		return nr_peso;
	}
	public void setNr_peso(double nr_peso) {
		this.nr_peso = nr_peso;
	}
	public String getDs_peso() {
		return ds_peso;
	}
	public void setDs_peso(String ds_peso) {
		this.ds_peso = ds_peso;
	}
	public Calendar getDt_peso() {
		return dt_peso;
	}
	public void setDt_peso(Calendar dt_peso) {
		this.dt_peso = dt_peso;
	}
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
}
