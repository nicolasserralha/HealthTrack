package br.com.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.healthtrack.bean.UsuarioBean;
import br.com.healthtrack.bo.UsuarioBo;

@WebServlet("/informacoes")
public class ServletMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMVC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioBo usuarioBo = new UsuarioBo();
		UsuarioBean usuario = new UsuarioBean();
		
				
		usuario.setNm_usuario(request.getParameter("nome"));
		//String nm_usuario = request.getParameter("nome");
		usuario.setDt_nascimento(request.getParameter("nascimento"));
		//String dt_nascimento =  request.getParameter("nascimento");
		usuario.setDs_sexo(request.getParameter("sexo"));
		//String ds_sexo = request.getParameter("sexo");
		usuario.setNr_altura(Float.parseFloat(request.getParameter("altura")));
		//float nr_altura = Float.parseFloat(request.getParameter("altura"));
		usuario.setDs_email(request.getParameter("email"));
		//String ds_email = request.getParameter("email");
		usuario.setDs_senha(request.getParameter("senha"));
		//String ds_senha = request.getParameter("senha");
		
		request.setAttribute("usuario", usuario);
		usuarioBo.insereUsuario(usuario);
		request.getRequestDispatcher("saida.jsp").forward(request, response);
/*		request.getRequestDispatcher(
				usuarioBo.insereUsuario(nm_usuario, dt_nascimento, ds_sexo, nr_altura, ds_email, ds_senha) == true 
				? "saida.jsp" 
				: "entrada.jsp").forward(request, response);*/
	}
}
