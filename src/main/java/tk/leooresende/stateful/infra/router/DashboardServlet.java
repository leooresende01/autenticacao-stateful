package tk.leooresende.stateful.infra.router;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.controller.DashboardController;
import tk.leooresende.stateful.infra.util.values.RotasPath;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private DashboardController dashboardController;

	public DashboardServlet() {
		this.dashboardController = new DashboardController();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			this.dashboardController.encaminharParaAPaginaInicialDeControle(req, resp, session);
		} catch (SQLException e) {
			resp.sendRedirect(RotasPath.LOGIN.getPath());
		}
	}
}
