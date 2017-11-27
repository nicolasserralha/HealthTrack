package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.healthtrack.bean.PesoBean;
import br.com.healthtrack.bo.PesoBo;

@WebServlet("/pesos")
public class PesoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PesoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PesoBo pesoBo = new PesoBo();
		PesoBean peso = new PesoBean();
		ArrayList<PesoBean> lista = new ArrayList<>();
		
		peso = pesoBo.popularObjeto(1, Double.parseDouble(request.getParameter("peso")), 
				request.getParameter("descricao"), request.getParameter("datapeso"));
		pesoBo.inserePeso(peso);
//		Popular o objeto Bean e inserir no banco -> PesoBo -> PesoDAO -> Banco
//		peso.setCd_usuario(1); //usuario
//		peso.setNr_peso(Double.parseDouble(request.getParameter("peso")));
//		peso.setDs_peso(request.getParameter("descricao"));
//		peso.setDt_peso(request.getParameter("datapeso"));
		//Popular o objeto Bean e inserir no banco -> PesoBo -> PesoDAO -> Banco
		
		lista = pesoBo.listaPeso();

		request.setAttribute("lista", lista);
		request.getRequestDispatcher("saidaPeso.jsp").forward(request, response);
		
	}
}