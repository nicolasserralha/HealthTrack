package br.com.healthtrack.bean;

import java.util.Calendar;
/*import java.io.Serializable;*/
import br.com.healthtrack.util.CriptografiaUtils;

public class UsuarioBean /*implements Serializable*/ {

	/*private static final long serialVersionUID = 1L;*/
	private int cd_usuario; //NUMBER(5) NOT NULL,
	private String nm_usuario; //VARCHAR2 (80) NOT NULL,
	private Calendar dt_nascimento; //DATE NOT NULL,
	private String ds_sexo; //CHAR(1) CHECK(UPPER(ds_sexo)='M' OR UPPER(ds_sexo)='F') NOT NULL, 
	private float nr_altura; //NUMBER(3,2) NOT NULL,
	private String ds_email; //VARCHAR2(100) NOT NULL,
	private String ds_senha; //CHAR(32) NOT NULL,
	
	//construtor padrão
	public UsuarioBean(){
	}
	
	//construtor completo
	public UsuarioBean(String nm_usuario, Calendar dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha){
		super();
		this.nm_usuario = nm_usuario;
		this.dt_nascimento = dt_nascimento;
		this.ds_sexo = ds_sexo;
		this.nr_altura = nr_altura;
		this.ds_email = ds_email;
		setDs_senha(ds_senha);
	}
	
	//construtor completo com codigo
	public UsuarioBean(int cd_usuario, String nm_usuario, Calendar dt_nascimento, String ds_sexo, float nr_altura, String ds_email, String ds_senha){
		super();
		this.cd_usuario = cd_usuario;
		this.nm_usuario = nm_usuario;
		this.dt_nascimento = dt_nascimento;
		this.ds_sexo = ds_sexo;
		this.nr_altura = nr_altura;
		this.ds_email = ds_email;
		setDs_senha(ds_senha);
	}
	
		
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public String getNm_usuario() {
		return nm_usuario;
	}
	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}
	public String getDs_email() {
		return ds_email;
	}
	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}
	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public String getDs_sexo() {
		return ds_sexo;
	}
	public void setDs_sexo(String ds_sexo) {
		this.ds_sexo = ds_sexo;
	}
	public float getNr_altura() {
		return nr_altura;
	}
	public void setNr_altura(float nr_altura) {
		this.nr_altura = nr_altura;
	}
	public String getDs_senha() {
		return ds_senha;
	}
	public void setDs_senha(String ds_senha) {
		try {
			this.ds_senha = CriptografiaUtils.criptografar(ds_senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

