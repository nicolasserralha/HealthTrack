package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bo.AtividadeBo;
import br.com.healthtrack.bean.AtividadeBean;

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
			
		case "adicionar":
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			request.setAttribute("novoRegistro", "sim");
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
			
		case "adicionarRegistro":
			String datax = request.getAttribute("data").toString();
			String hora = request.getAttribute("hora").toString();
			String categoriax = request.getAttribute("categoria").toString();
			int categoria = Integer.parseInt(categoriax);
			String ds_atividade = request.getAttribute("descricao").toString();
			String calorias = request.getAttribute("calorias").toString();
			Double nr_caloria = Double.parseDouble(calorias);
			
			atividade.inserirAtividade(id, datax, hora, categoria, ds_atividade, nr_caloria);
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
			
		case "alterar":
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			int codigo = Integer.parseInt(request.getAttribute("codigo").toString());
			AtividadeBean atividadeAlterar = atividade.buscarAtividade(codigo);
			request.setAttribute("objeto", atividadeAlterar);
			request.setAttribute("alterar", "sim");
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
			
		case "alterarAtividade":
			String dataxx = request.getAttribute("data").toString();
			String horax = request.getAttribute("hora").toString();
			String categoriaxx = request.getAttribute("categoria").toString();
			int categoriaxz = Integer.parseInt(categoriaxx);
			String ds_atividadex = request.getAttribute("descricao").toString();
			String caloriasx = request.getAttribute("calorias").toString();
			Double nr_caloriax = Double.parseDouble(caloriasx);
			
			atividade.editarAtividade(id, dataxx, horax, categoriaxz, ds_atividadex, nr_caloriax);
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
			
		case "excluir":
			int codigox = Integer.parseInt(request.getAttribute("codigo").toString());
			String mensagem = atividade.excluirAtividade(codigox);
			request.setAttribute("mensagemRemover", mensagem);
			lista = atividade.listarAtividade(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AtividadeBo bo = new AtividadeBo();
		HttpSession sessao = request.getSession();
		
		int codigoUsuario = Integer.parseInt(sessao.getAttribute("id").toString());
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		int categoria = Integer.parseInt(request.getAttribute("categoria").toString());
		String ds_atividade = request.getParameter("descricao");
		double nr_caloria = Double.parseDouble(request.getParameter("calorias"));
		
		if(bo.inserirAtividade(codigoUsuario, data, hora, categoria, ds_atividade, nr_caloria ) != null){
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
		}
		else{
			request.setAttribute("erroAtividade", "Erro ao cadastrar atividade");
			request.getRequestDispatcher("atividade.jsp").forward(request, response);
		}
	}
	
}
