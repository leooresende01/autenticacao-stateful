package tk.leooresende.stateful.infra.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.controller.RootPathController;


@WebServlet(urlPatterns = "")
public class RootPathServlet extends HttpServlet {
	private RootPathController rootController;
	
	public RootPathServlet() {
		this.rootController = new RootPathController();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.rootController.redirecionarParaAPaginaDeLogin(req, resp);
	}
}
