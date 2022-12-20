package tk.leooresende.stateful.infra.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RootPathController {

	private static final String LOGIN_PATH = "/login";

	public void redirecionarParaAPaginaDeLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(RootPathController.LOGIN_PATH);
	}

}
