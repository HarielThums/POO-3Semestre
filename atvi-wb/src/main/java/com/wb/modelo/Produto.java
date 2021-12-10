package com.wb.modelo;

public class Produto {
	public String nome;
	private double preco;

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

}