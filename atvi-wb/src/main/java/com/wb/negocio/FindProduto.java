package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class FindProduto extends Find {
  private List<Produto> produtos;
  private Produto produto;

  public FindProduto(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public Produto find() {
    Entrada entrada = new Entrada();

    System.out.println("\nInsira o nome do produto: ");

    String nome = entrada.receberTexto();

    for (Produto v : produtos) {
      if (v.nome.equals(nome))
        this.produto = v;
    }

    return this.produto;
  }
}
