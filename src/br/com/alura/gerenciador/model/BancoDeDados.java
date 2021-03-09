package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.gerenciador.entities.Empresa;

public class BancoDeDados {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		lista.add(new Empresa(1, "Alura"));
		lista.add(new Empresa(2, "Caelum"));
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(lista);
	}

}
