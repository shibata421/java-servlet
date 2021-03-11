package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	private static final NovaEmpresa instancia = new NovaEmpresa();
	private NovaEmpresa() {}
	
	public static NovaEmpresa getInstance() {
		return instancia;
	}
	
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Nova Empresa sendo cadastrada");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataDeCriacao = request.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setData(dataDeCriacao);
		
		BancoDeDados banco = BancoDeDados.getInstancia();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura().toString());
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);
	}
}
