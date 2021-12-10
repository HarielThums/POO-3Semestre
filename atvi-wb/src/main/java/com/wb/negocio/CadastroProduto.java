package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro {
  private List<Produto> produtos;
  private Entrada entrada;

  public CadastroProduto(List<Produto> produtos) {
    this.produtos = produtos;
    this.entrada = new Entrada();
  }

  @Override
  public void cadastrar() {
		System.out.println("\nIn�cio do cadastro do produto");
		System.out.println("Por favor informe o nome do produto:");

    String nome = entrada.receberTexto();

		System.out.println("Por favor informe o preco do produto:");

		double preco = entrada.receberNumeroDouble();

    produtos.add(new Produto(nome, preco));
  }
}