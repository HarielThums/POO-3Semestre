package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class FindClient extends Find {
  private List<Cliente> clientes;
  private Cliente cliente;

  public FindClient(List<Cliente> clientes) {
    this.clientes = clientes;
  }

  @Override
  public Cliente find() {
    Entrada entrada = new Entrada();

    System.out.println("\nInsira o CPF do cliente: ");
    String cpf = entrada.receberTexto();

    for (Cliente v : clientes) {
      if (v.getCpf().getValor().equals(cpf))
        this.cliente = v;
    }

    return this.cliente;
  }
}
