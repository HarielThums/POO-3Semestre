package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class AtualizarServico extends Atualizar {

  private Servico servico;
  private Entrada entrada;

  public AtualizarServico(Servico servico) {
    this.servico = servico;
    this.entrada = new Entrada();
  }

  @Override
  public void atualizar() {
    System.out.println("\nEditar:");
    System.out.println("1️ - Nome");
    System.out.println("2️ - preco");

    int control = entrada.receberNumeroInteiro();

    switch (control) {
      case 1: {
        Entrada entrada = new Entrada();

        System.out.print("Novo nome: ");

        String nome = entrada.receberTexto();

        servico.setNome(nome);

        System.out.println("Nome editado");

        break;
      }
      case 2: {
        Entrada entrada = new Entrada();

        System.out.print("Novo preco: ");

        double preco = entrada.receberNumeroDouble();

        servico.setPreco(preco);

        System.out.println("Nome social editado");

        break;
      }
      default:
        System.out.println("Opera��o n�o entendida? \n");
    }

  }

}
