package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.DeletaEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = ListaEmpresas.getInstance();
			acao.executa(request, response);

		} else if (paramAcao.equals("DeletaEmpresa")) {
			DeletaEmpresa acao = DeletaEmpresa.getInstance();
			acao.executa(request, response);

		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = MostraEmpresa.getInstance();
			acao.executa(request, response);

		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = AlteraEmpresa.getInstance();
			acao.executa(request, response);

		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = NovaEmpresa.getInstance();
			acao.executa(request, response);
		}

	}

}
