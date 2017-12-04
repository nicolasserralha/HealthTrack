package br.com.healthtrack.bean;

public class CategoriaAlimentoBean {
	
	private int cd_cat_alimento;
	private String ds_cat_alimento;
	
	public CategoriaAlimentoBean() {
		super();
	}
		
	public CategoriaAlimentoBean(int cd_cat_alimento, String ds_cat_alimento) {
		super();
		this.cd_cat_alimento = cd_cat_alimento;
		this.ds_cat_alimento = ds_cat_alimento;
	}
	
	public int getCd_cat_alimento() {
		return cd_cat_alimento;
	}
	public void setCd_cat_alimento(int cd_cat_alimento) {
		this.cd_cat_alimento = cd_cat_alimento;
	}
	public String getDs_cat_alimento() {
		return ds_cat_alimento;
	}
	public void setDs_cat_alimento(String ds_cat_alimento) {
		this.ds_cat_alimento = ds_cat_alimento;
	}


	
}
