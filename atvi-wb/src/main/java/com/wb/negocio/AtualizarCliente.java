package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class AtualizarCliente extends Atualizar {
  private Cliente cliente;
  private Entrada entrada;

  public AtualizarCliente(Cliente cliente) {
    this.cliente = cliente;
    this.entrada = new Entrada();
  }

  @Override
  public void atualizar() {
    System.out.println("\nEditar:");
    System.out.println("1️ - Nome");
    System.out.println("2️ - Nome Social");
    System.out.println("3️ - CPF");
    System.out.println("4 - Gênero");
    System.out.println("5 - Telefone");
    System.out.println("0 - Sair");

    int control = entrada.receberNumeroInteiro();

    switch (control) {
      case 1: {
        Entrada entradaNome = new Entrada();

        System.out.println("Novo nome: ");

        String nome = entradaNome.receberTexto();

        cliente.nome = nome;

        System.out.println("Nome editado");

        break;
      }
      case 2: {
        Entrada entradaNomeSocial = new Entrada();

        System.out.println("Novo nome social: ");

        String nomeSocial = entradaNomeSocial.receberTexto();

        cliente.nomeSocial = nomeSocial;

        System.out.println("Nome social editado");

        break;
      }
      case 3: {
        entrada = new Entrada();

        System.out.println("CPF: ");

        String valor = entrada.receberTexto();

        System.out.println("Data de Emissão CPF: ");

        String data = entrada.receberTexto();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataEmissao = LocalDate.parse(data, formato);

        cliente.setCpf(new CPF(dataEmissao, valor));

        System.out.println("CPF editado");

        break;
      }
      case 4: {
        System.out.println("Por favor informe o gênero (M/F/Outro):");

        String genero = entrada.receberTexto();

        cliente.setGenero(genero);

        System.out.println("Gênero editado");

        break;
      }
      case 5: {
        System.out.println("\n1 - Adicionar telefone");
        System.out.println("2 - Editar telefone");
        System.out.println("3️ - Apagar telefone");
        System.out.println("0 - sair");
        System.out.print("Qual operação deseja realizar? ");

        int operacaoTel = entrada.receberNumeroInteiro();

        List<Telefone> userTelefones = cliente.getTelefones();

        if (operacaoTel == 2 || operacaoTel == 3) {
          System.out.println("\nQual número deseja " + (operacaoTel == 2 ? "editar" : "deletar") + "? ");

          int i = 0;
          for (Telefone telefone : userTelefones) {
            System.out.println(i + " - (" + telefone.getDdd() + ") " + telefone.getNumero());
            i++;
          }
        }

        switch (operacaoTel) {
          case 1: {
            Telefones telefones = new Telefones(cliente.getTelefones());

            telefones.adicionar();

            break;
          }
          case 2: {
            Telefones telefones = new Telefones(cliente.getTelefones());

            telefones.editar();

            break;
          }
          case 3: {
            Telefones telefones = new Telefones(cliente.getTelefones());

            telefones.remover();

            break;
          }
          default:
            System.out.println("Opera��o n�o entendida \n");
        }
        break;
      }
      default:
        System.out.println("Opera��o n�o entendida? \n");
    }
  }
}
