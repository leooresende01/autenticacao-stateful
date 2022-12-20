package tk.leooresende.stateful.infra.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.controller.LoggoutController;
import tk.leooresende.stateful.infra.util.values.RotasPath;

@WebServlet("/loggout")
public class LoggoutServlet extends HttpServlet {
	private LoggoutController controller;
	
	public LoggoutServlet() {
		this.controller = new LoggoutController();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.controller.fazerLoggout(req, resp);
		resp.sendRedirect(RotasPath.LOGIN.getPath());
	}
}
