package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;

public class DeletarCliente extends Deletar {
  private Cliente cliente;
  private List<Cliente> clientes;

  public DeletarCliente(List<Cliente> clientes, Cliente cliente) {
    this.clientes = clientes;
    this.cliente = cliente;
  }

  @Override
  public void deletar() {
    this.clientes.remove(this.cliente);
  }

}
