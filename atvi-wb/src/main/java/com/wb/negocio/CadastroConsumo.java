package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;
import com.wb.modelo.Servico;

public class CadastroConsumo extends Cadastro {
  private List<Cliente> clientes;
  private List<Produto> produtos;
  private List<Servico> servicos;
  private List<Consumo> consumos;
  private Entrada entrada;
  private Cliente cliente;

  public CadastroConsumo(List<Produto> produtos, List<Servico> servicos, List<Cliente> clientes,
      List<Consumo> consumos) {
    this.entrada = new Entrada();
    this.clientes = clientes;
    this.consumos = consumos;
    this.produtos = produtos;
    this.servicos = servicos;
  }

  @Override
  public void cadastrar() {
    System.out.println("\nIn�cio do cadastro do consumo:");
    System.out.println("1 - Cadastrar consumo de produto");
    System.out.println("2 - Cadastrar consumo de servico");
    System.out.println("3 - sair\n");

    int op = this.entrada.receberNumeroInteiro();

    switch (op) {
      case 1: {
        getConsumidor();

        if (this.cliente == null) {
          System.out.println("cliente não registrado");

          break;
        }

        System.out.println("\nProdutos: ");

        int i = 0;
        for (Produto prod : produtos) {
          System.out.println(i + " - " + prod.getNome());
          i++;
        }

        System.out.println("\nQual produto adicionar ao consumo?");

        int index = this.entrada.receberNumeroInteiro();

        Produto produto = this.produtos.get(index);

        Consumo consumo = new Consumo(produto, this.cliente, "produto");

        this.consumos.add(consumo);

        this.cliente.setConsumos(consumo);

        break;
      }
      case 2: {
        getConsumidor();

        if (this.cliente == null) {
          System.out.println("\ncliente não registrado");

          break;
        }

        System.out.println("\nServicos: ");

        int i = 0;
        for (Servico serv : servicos) {
          System.out.println(i + " - " + serv.getNome());
          i++;
        }

        System.out.println("\nQual servico adicionar ao consumo?");

        int index = this.entrada.receberNumeroInteiro();

        Servico servico = this.servicos.get(index);

        Consumo consumo = new Consumo(servico, this.cliente, "servico",);

        this.consumos.add(consumo);

        this.cliente.setConsumos(consumo);

        break;
      }
      default:
        System.out.println("Opera��o n�o entendida \n");
    }

  }

  private void getConsumidor() {
    Entrada entrada = new Entrada();

    System.out.println("Por favor informe o n�mero do cpf do consumidor:");

    String cpf = entrada.receberTexto();

    for (Cliente v : clientes) {
      if (v.getCpf().getValor().equals(cpf))
        this.cliente = v;
    }
  }

}
