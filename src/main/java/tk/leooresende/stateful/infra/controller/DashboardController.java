package tk.leooresende.stateful.infra.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardController {

	private static final String DASHBOARD_PAGE = "WEB-INF/dashboard/index.jsp";

	public void encaminharParaAPaginaInicialDeControle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(DashboardController.DASHBOARD_PAGE).forward(req, resp);
	}

}
