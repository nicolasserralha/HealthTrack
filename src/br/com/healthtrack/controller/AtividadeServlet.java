package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bo.AtividadeBo;
import br.com.healthtrack.bean.AtividadeBean;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.impl.IAtividadeDAO;

/**
 * Servlet implementation class AtividadeServlet
 */
@WebServlet("/AtividadeServlet")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getAttribute("action").toString();
		AtividadeBo atividade = new AtividadeBo();
		List<AtividadeBean> lista;
		HttpSession sessao = request.getSession();
		int id = Integer.parseInt(sessao.getAttribute("id").toString()); 

		switch(acao) {
		case "listar": 
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
