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
@WebFilter("/AtividadeServlet")
public class AtividadeFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    String url = req.getRequestURI();
    String parametro = req.getParameter("action");
    String codigo = req.getParameter("codigo");
    
    if(parametro != null){
    	url = url + "/" + parametro;
  	}
    	
    	if(url.contains("AtividadeServlet")){
    		if(url.endsWith("adicionar")){
	    		req.setAttribute("action", "adicionar");
	    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
	    		return;
	    	}
	    	else if(url.contains("alterar")){
	    		req.setAttribute("action", "alterar");
	    		req.setAttribute("codigo", codigo);
	    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
	    		return;
	    	}
	    	else if(url.contains("excluir")){
	    		req.setAttribute("action", "excluir");
	    		req.setAttribute("codigo", codigo );
	    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
	    		return;
	    	}
	    	else if (url.contains("adicionarRegistro")){
	    		
	    	    String data = req.getParameter("data");
	    	    String hora = req.getParameter("hora");
	    	    String categoria = req.getParameter("categoria");
	    	    String descricao = req.getParameter("descricao");
	    	    String calorias = req.getParameter("calorias");
	    		
	    		req.setAttribute("action", "adicionarRegistro");
	    		req.setAttribute("data", data );
	    		req.setAttribute("hora", hora );
	    		req.setAttribute("categoria", categoria );
	    		req.setAttribute("descricao", descricao );
	    		req.setAttribute("calorias", calorias );
	    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
	    		return;
	    	}
	    	else if (url.contains("atualizarRegistro")){
	    		
	    	    String data = req.getParameter("data");
	    	    String hora = req.getParameter("hora");
	    	    String categoria = req.getParameter("categoria");
	    	    String descricao = req.getParameter("descricao");
	    	    String calorias = req.getParameter("calorias");
	    		
	    		req.setAttribute("action", "adicionarRegistro");
	    		req.setAttribute("data", data );
	    		req.setAttribute("hora", hora );
	    		req.setAttribute("categoria", categoria );
	    		req.setAttribute("descricao", descricao );
	    		req.setAttribute("calorias", calorias );
	    		req.getRequestDispatcher("AtividadeServlet").forward(req, response);
	    		return;
	    	}
    	}
    	//AQUI TERMINA A PARTE DA ATIVIDADE
      chain.doFilter(req, response);
    }
}
  

