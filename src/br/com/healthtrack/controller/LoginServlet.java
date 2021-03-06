package br.com.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bo.EmailBo;
import br.com.healthtrack.bo.UsuarioBo;
import br.com.healthtrack.exception.EmailException;

@WebServlet("/logar")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmailBo bo;
	private UsuarioBo usuarioBo;
	
    public LoginServlet() {
    	bo = new EmailBo();
	    usuarioBo = new UsuarioBo();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  session.invalidate();
		  request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    boolean teste = false;
	    int id = usuarioBo.validaUsuario(email, senha);
	    String nome = usuarioBo.buscaNome(id);
	    
	    if (id > 0) {
	      HttpSession session = request.getSession();
	      session.setAttribute("user", nome);
	      session.setAttribute("id", id);
	      String mensagem = "Um login foi realizado";
	      teste = true;
	      try {
	        bo.enviarEmail(email, "Login Realizado", mensagem);
	      } catch (EmailException e) {
	        e.printStackTrace();
	      }
	    }
	    else {
	      request.setAttribute("erroLogin", "Usu�rio e/ou senha inv�lidos");
	    }
	    if(teste) {
	    	request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	    }
	    else{
	    	request.getRequestDispatcher("index.jsp").forward(request, response);	
	    }
	}
}