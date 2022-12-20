package tk.leooresende.stateful.infra.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.controller.DashboardController;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private DashboardController dashboardController;

	public DashboardServlet() {
		this.dashboardController = new DashboardController();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.dashboardController.encaminharParaAPaginaInicialDeControle(req, resp);
	}
}
