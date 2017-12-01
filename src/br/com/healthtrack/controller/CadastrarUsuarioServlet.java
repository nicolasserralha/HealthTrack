package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.healthtrack.bo.UsuarioBo;
import br.com.healthtrack.exception.DBException;

@WebServlet("/cadastrar")
public class CadastrarUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioBo usuarioBo;
       
    public CadastrarUsuarioServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
      super.init();
      /*dao = DAOFactory.getProdutoDAO();*/
      usuarioBo = new UsuarioBo();
    }

/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			request.setCharacterEncoding("UTF8");
			String nm_usuario = request.getParameter("nome");
			//FORMATACAO DA DATA
			Calendar dt_nascimento = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			dt_nascimento.setTime(format.parse(request.getParameter("data-nascimento")));
			//FORMATACAO DA DATA
			String ds_sexo = request.getParameter("radio-genero"); //CHAR(1) CHECK(UPPER(ds_sexo)='M' OR UPPER(ds_sexo)='F') NOT NULL, 
			float nr_altura = Float.parseFloat(request.getParameter("altura")); //NUMBER(3,2) NOT NULL 
			String ds_email = request.getParameter("email"); //VARCHAR2(100) NOT NULL,
			String ds_senha = request.getParameter("pwd"); //CHAR(32) NOT NULL,
			
			usuarioBo.insereUsuario(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha);
			request.setAttribute("msg", "Usuário cadastrado com sucesso. Faça o Login =)");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

}
