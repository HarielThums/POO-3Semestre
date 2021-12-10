package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;


public class DeletarProduto extends Deletar {
  private Produto produto;
  private List<Produto> produtos;

  public DeletarProduto(List<Produto> produtos, Produto produto) {
    this.produtos = produtos;
    this.produto = produto;
  }

  @Override
  public void deletar() {
    this.produtos.remove(this.produto);
  }

}
