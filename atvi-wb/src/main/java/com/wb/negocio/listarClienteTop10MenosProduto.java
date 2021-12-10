package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;

public class listarClienteTop10MenosProduto extends Listagem {
	private List<Cliente> clientes;

	public listarClienteTop10MenosProduto(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void listar() {

	}
}
