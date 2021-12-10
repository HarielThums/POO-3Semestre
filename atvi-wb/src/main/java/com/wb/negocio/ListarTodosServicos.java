package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servicos;

	public ListarTodosServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todos os servicos:");

		if (this.servicos.size() == 0)
			System.out.println(" - Nenhum servico cadastrado");

		for (Servico servico : servicos) {
			System.out.println("Nome: " + servico.nome);
			System.out.println("Preco: " + servico.getPreco());

			System.out.println("--------------------------------------");
		}
	}
}
