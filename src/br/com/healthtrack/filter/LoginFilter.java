package br.com.healthtrack.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    String url = req.getRequestURI();
    
    if (session.getAttribute("user") == null && !url.endsWith("logar") && !url.contains("resources") && !url.contains("index")) {
    	req.setAttribute("erroLogin", "Entre com o usuário e senha!");
    	req.getRequestDispatcher("index.jsp").forward(request, response);
    }else {
    	if(url.contains("atividade")){
    		req.setAttribute("action", "listar");
    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
    		return;
    	}
    	else if(url.endsWith("AtividadeServlet")){
    		req.setAttribute("action", "adicionar");
    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
    		return;
    	}
    	
      chain.doFilter(req, response);
    }
    
  }

}



