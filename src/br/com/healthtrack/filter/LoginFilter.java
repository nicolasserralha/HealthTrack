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
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		String parametro = req.getParameter("action");
		String codigo = req.getParameter("codigo");
		if (parametro != null) {
			url = url + "/" + parametro;
		}

		if (session.getAttribute("user") == null && !url.endsWith("logar") && !url.contains("resources")
				&& !url.contains("index") && !url.contains("cadastrar") && !url.contains("cadastro")) {
			req.setAttribute("erroLogin", "Entre com o usu�rio e senha!");
			req.getRequestDispatcher("index.jsp").forward(request, response);
		}

		else {

			if (url.endsWith("atividade.jsp")) {
				req.setAttribute("action", "listar");
				req.getRequestDispatcher("AtividadeServlet").forward(req, response);
				return;
			} else if (url.endsWith("peso.jsp")) {
				req.setAttribute("action", "listar");
				req.getRequestDispatcher("PesoServlet").forward(req, response);
				return;
			} else if (url.endsWith("pressao.jsp")) {
				req.setAttribute("action", "listar");
				req.getRequestDispatcher("PressaoServlet").forward(req, response);
				return;
			} else if (url.endsWith("alimentacao.jsp")) {
				req.setAttribute("action", "listar");
				req.getRequestDispatcher("AlimentoServlet").forward(req, response);
				return;
			}

			// AQUI COME�A A PARTE DA ATIVIDADE
			if (url.contains("AtividadeServlet")) {
				if (url.endsWith("adicionar")) {
					req.setAttribute("action", "adicionar");
					req.getRequestDispatcher("AtividadeServlet").forward(req, response);
					return;
				} else if (url.contains("alterar")) {
					req.setAttribute("action", "alterar");
					req.setAttribute("codigo", codigo);
					req.getRequestDispatcher("AtividadeServlet").forward(req, response);
					return;
				} else if (url.contains("excluir")) {
					req.setAttribute("action", "excluir");
					req.setAttribute("codigo", codigo);
					req.getRequestDispatcher("AtividadeServlet").forward(req, response);
					return;
				} else if (url.contains("adicionarRegistro")) {

					String data = req.getParameter("data");
					String hora = req.getParameter("hora");
					String categoria = req.getParameter("categoria");
					String descricao = req.getParameter("descricao");
					String calorias = req.getParameter("calorias");

					req.setAttribute("action", "adicionarRegistro");
					req.setAttribute("data", data);
					req.setAttribute("hora", hora);
					req.setAttribute("categoria", categoria);
					req.setAttribute("descricao", descricao);
					req.setAttribute("calorias", calorias);
					req.getRequestDispatcher("AtividadeServlet").forward(req, response);
					return;
				} else if (url.contains("atualizarRegistro")) {
					
					String data = req.getParameter("data");
					String hora = req.getParameter("hora");
					String categoria = req.getParameter("categoria");
					String descricao = req.getParameter("descricao");
					String calorias = req.getParameter("calorias");
					
					req.setAttribute("action", "atualizarRegistro");
					req.setAttribute("codigo", codigo);
					req.setAttribute("data", data);
					req.setAttribute("hora", hora);
					req.setAttribute("categoria", categoria);
					req.setAttribute("descricao", descricao);
					req.setAttribute("calorias", calorias);
					req.getRequestDispatcher("AtividadeServlet").forward(req, response);
					return;
				}
			}
			// AQUI TERMINA A PARTE DA ATIVIDADE

			if (url.contains("AlimentoServlet")) {
				if (url.endsWith("adicionar")) {
					req.setAttribute("action", "adicionar");
					req.getRequestDispatcher("AlimentoServlet").forward(req, response);
					return;
				} else if (url.contains("alterar")) {
					req.setAttribute("action", "alterar");
					req.setAttribute("codigo", codigo);
					req.getRequestDispatcher("AlimentoServlet").forward(req, response);
					return;
				} else if (url.contains("excluir")) {
					req.setAttribute("action", "excluir");
					req.setAttribute("codigo", codigo);
					req.getRequestDispatcher("AlimentoServlet").forward(req, response);
					return;
				} else if (url.contains("adicionarRegistro")) {

					String data = req.getParameter("data");
					String hora = req.getParameter("hora");
					String categoria = req.getParameter("categoria");
					String descricao = req.getParameter("descricao");
					String calorias = req.getParameter("calorias");

					req.setAttribute("action", "adicionarRegistro");
					req.setAttribute("data", data);
					req.setAttribute("hora", hora);
					req.setAttribute("categoria", categoria);
					req.setAttribute("descricao", descricao);
					req.setAttribute("calorias", calorias);
					req.getRequestDispatcher("AlimentoServlet").forward(req, response);
					return;
				} else if (url.contains("atualizarRegistro")) {

					String data = req.getParameter("data");
					String hora = req.getParameter("hora");
					String categoria = req.getParameter("categoria");
					String descricao = req.getParameter("descricao");
					String calorias = req.getParameter("calorias");

					req.setAttribute("action", "atualizarRegistro");
					req.setAttribute("codigo", codigo);
					req.setAttribute("data", data);
					req.setAttribute("hora", hora);
					req.setAttribute("categoria", categoria);
					req.setAttribute("descricao", descricao);
					req.setAttribute("calorias", calorias);
					req.getRequestDispatcher("AlimentoServlet").forward(req, response);
					return;
				}
			}
			// AQUI TERMINA A PARTE DA ATIVIDADE
			chain.doFilter(req, response);
		}
	}
}
