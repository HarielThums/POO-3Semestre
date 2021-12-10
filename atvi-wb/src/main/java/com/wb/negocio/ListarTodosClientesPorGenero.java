package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class ListarTodosClientesPorGenero extends Listagem {
  private List<Cliente> clientes;
  private String genero;

  public ListarTodosClientesPorGenero(List<Cliente> clientes, String genero) {
    this.clientes = clientes;
    this.genero = genero;
  }

  @Override
  public void listar() {
    System.out.println("\nLista de todos os clientes com genero " + genero + ":");

    if (this.clientes.size() == 0)
      System.out.println(" - Nenhum cliente cadastrado");

    for (Cliente cliente : clientes) {
      if (cliente.getGenero().equals(this.genero)) {
        System.out.println("Nome: " + cliente.nome);
        System.out.println("Nome social: " + cliente.nomeSocial);
        System.out.println("CPF: " + cliente.getCpf().getValor());
        System.out.println("Gênero: " + cliente.getGenero());

        List<Telefone> telefones = cliente.getTelefones();

        System.out.println("Telefone(s): ");

        if (telefones.size() == 0)
          System.out.println(" - Nenhum telefone cadastrado");

        for (Telefone telefone : telefones)
          System.out.println(" - (" + telefone.getDdd() + ") " + telefone.getNumero());

        System.out.println("--------------------------------------");
      }
    }
  }

}
