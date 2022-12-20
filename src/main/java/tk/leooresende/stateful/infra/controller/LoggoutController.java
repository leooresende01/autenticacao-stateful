package tk.leooresende.stateful.infra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.leooresende.stateful.infra.util.values.SessionAttributes;

public class LoggoutController {

	public void fazerLoggout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute(SessionAttributes.USERNAME_USUARIO_AUTENTICADO.getValue());
		session.removeAttribute(SessionAttributes.NEXT_URL.getValue());
	}

}
