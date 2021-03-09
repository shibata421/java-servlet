package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.entities.Empresa;
import br.com.alura.gerenciador.model.BancoDeDados;

@WebServlet("/editarEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String id;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDeDados banco = new BancoDeDados();
		id = request.getParameter("id");
		
		Empresa empresa = banco.pega(id);
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura().toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostraEmpresa.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDeDados banco = new BancoDeDados();
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		
		banco.edita(id, nome, data);
		response.sendRedirect("listaEmpresas");
	}
}
