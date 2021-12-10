package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public String nomeSocial;
	private String genero;
	private CPF cpf;
	private List<RG> rgs;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private List<Produto> produtosConsumidos;
	private List<Servico> servicosConsumidos;
	private List<Consumo> consumos;

	public Cliente(String nome, String nomeSocial, CPF cpf, String genero) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.genero = genero;
		this.rgs = new ArrayList<>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<>();
		this.produtosConsumidos = new ArrayList<>();
		this.servicosConsumidos = new ArrayList<>();
		this.consumos = new ArrayList<>();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public CPF getCpf() {
		return cpf;
	}

	public List<RG> getRgs() {
		return rgs;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}

	public List<Servico> getServicosConsumidos() {
		return servicosConsumidos;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public void setRgs(List<RG> rgs) {
		this.rgs = rgs;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void setProdutosConsumidos(List<Produto> produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(Consumo consumo) {
		this.consumos.add(consumo);
	}

	public void setServicosConsumidos(List<Servico> servicosConsumidos) {
		this.servicosConsumidos = servicosConsumidos;
	}

}