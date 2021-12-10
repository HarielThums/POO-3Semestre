package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;

public class listarClienteTop10MaisProduto extends Listagem {
	private List<Cliente> clientes;
	private List<Cliente> MaioresClientes;
	private List<Consumo> consumos;

	public listarClienteTop10MaisProduto(List<Cliente> clientes, List<Consumo> consumos) {
		this.clientes = clientes;
		this.consumos = consumos;
	}

	@Override
	public void listar() {

		int i = 0;
		for (Cliente cliente : clientes) {
			List<Consumo> consumos = cliente.getConsumos();
			
			consumos.size();
			i++;
		}

	}

}
