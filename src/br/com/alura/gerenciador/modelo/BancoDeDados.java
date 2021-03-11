package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDeDados {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static final BancoDeDados intancia = new BancoDeDados();
	
	static {
		lista.add(new Empresa(chaveSequencial++, "Alura"));
		lista.add(new Empresa(chaveSequencial++, "Caelum"));
	}
	
	private BancoDeDados() {}

	public static BancoDeDados getInstancia() {
		return intancia;
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(lista);
	}

	public void deleta(String id) {
		int empresaId = Integer.valueOf(id);
		
//		Iterator<Empresa> it = lista.iterator();
//		while (it.hasNext()) {
//			Empresa emp = it.next();
//			if(emp.getId() == empresaId) {
//				it.remove();
//			}
//		}
		
		lista = lista.stream()
				.filter(empresa -> empresa.getId() != empresaId)
				.collect(Collectors.toList());
		
	}

	public Empresa pega(String id) {
		return lista.stream()
				.filter(empresa -> empresa.getId() == Integer.valueOf(id))
				.findFirst()
				.orElseThrow();
	}

	public void edita(String id, String nome, String data) {
		Empresa empresa = pega(id);
		empresa.setNome(nome);
		empresa.setData(data);
	}

}
