package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

public class AlteraEmpresa {

	private static final AlteraEmpresa instancia = new AlteraEmpresa();
	private AlteraEmpresa() {}

	public static AlteraEmpresa getInstance() {
		return instancia;
	}

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BancoDeDados banco = BancoDeDados.getInstancia();

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String id = request.getParameter("id");

		System.out.println("alterando empresa " + id);

		banco.edita(id, nome, data);
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
