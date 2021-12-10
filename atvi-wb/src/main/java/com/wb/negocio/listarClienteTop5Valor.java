package com.wb.negocio;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;

public class listarClienteTop5Valor extends Listagem {
	private List<Cliente> clientes;

	public void listar() {
		Map<Cliente, Double> lista = new HashMap<Cliente, Double>();

		for (Cliente cliente : clientes) {
			double produtos = 0;
			
			for (Consumo consumo : cliente.getConsumos()) {
				if (consumo.getTipo() == "produto") {
					produtos += consumo.getProduto().getPreco();
				} else if (consumo.getTipo() == "servico") {
					produtos += consumo.getServico().getPreco();
				}
			}
			lista.put(cliente, produtos);
		}

		Map<Cliente, Double> listando = new TreeMap<Cliente, Double>(Collections.reverseOrder());
		listando.putAll(lista);

		int i = 0;
		for (Entry<Cliente, Double> entry : lista.entrySet()) {
			System.out.println("Nome: " + entry.getKey().nome + ", " + "Quantidade: " + entry.getValue());
			i++;

			if (i > 4)
				break;
		}

		System.out.println("--------------------------------------");
	}

}