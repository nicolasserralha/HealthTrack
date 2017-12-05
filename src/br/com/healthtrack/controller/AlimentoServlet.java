package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bean.AlimentoBean;
import br.com.healthtrack.bo.AlimentoBo;

/**
 * Servlet implementation class AlimentoServlet
 */
@WebServlet("/AlimentoServlet")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getAttribute("action").toString();
		AlimentoBo alimento = new AlimentoBo();
		List<AlimentoBean> lista;
		HttpSession sessao = request.getSession();
		int id = Integer.parseInt(sessao.getAttribute("id").toString());
		
		switch(acao) {
		
		case "listar": 
			lista = alimento.listarAlimento(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
			
		case "adicionar":
			lista = alimento.listarAlimento(id);
			request.setAttribute("lista", lista);
			request.setAttribute("novoRegistro", "sim");
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
			
		case "adicionarRegistro":
			String datax = request.getAttribute("data").toString();
			String hora = request.getAttribute("hora").toString();
			String categoriax = request.getAttribute("categoria").toString();
			int categoria = Integer.parseInt(categoriax);
			String ds_alimento = request.getAttribute("descricao").toString();
			String calorias = request.getAttribute("calorias").toString();
			Double nr_caloria = Double.parseDouble(calorias);
			
			alimento.inserirAlimento(id, datax, hora, categoria, ds_alimento, nr_caloria);
			lista = alimento.listarAlimento(id);
			
			request.setAttribute("lista", lista);
			request.setAttribute("mensagemSucesso", "Adicionado com Sucesso");
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
			
		case "alterar":
			lista = alimento.listarAlimento(id);
			request.setAttribute("lista", lista);
			int codigo = Integer.parseInt(request.getAttribute("codigo").toString());
			AlimentoBean alimentoAlterar = alimento.buscarAlimento(codigo);
			request.setAttribute("objeto", alimentoAlterar);
			request.setAttribute("alterar", "sim");
			acao = null;
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
			
		case "atualizarRegistro":
			String dataxx = request.getAttribute("data").toString();
			String horax = request.getAttribute("hora").toString();
			String categoriaxx = request.getAttribute("categoria").toString();
			int categoriaxz = Integer.parseInt(categoriaxx);
			String ds_alimentox = request.getAttribute("descricao").toString();
			String caloriasx = request.getAttribute("calorias").toString();
			Double nr_caloriax = Double.parseDouble(caloriasx);
			
			alimento.editarAlimento(id, dataxx, horax, categoriaxz, ds_alimentox, nr_caloriax);
			lista = alimento.listarAlimento(id);
			request.setAttribute("lista", lista);
			request.setAttribute("mensagemSucesso", "Atualizado com Sucesso");
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
			
		case "excluir":
			int codigox = Integer.parseInt(request.getAttribute("codigo").toString());
			String mensagem = alimento.excluirAlimento(codigox);
			request.setAttribute("mensagemRemover", mensagem);
			lista = alimento.listarAlimento(id);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
