package tk.leooresende.stateful.infra.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.leooresende.stateful.infra.util.values.RotasPath;

public class RootPathController {

	public void redirecionarParaAPaginaDeLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(RotasPath.LOGIN.getPath());
	}

}
