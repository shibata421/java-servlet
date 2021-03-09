package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("Oi Mundo!");
		out.print("</body>");
		out.print("</html>");

		System.out.println("OiMundoServlet foi chamado");
	}

}
