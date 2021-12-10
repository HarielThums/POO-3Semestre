package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Telefone;

public class Telefones {
  private List<Telefone> telefones;
  private Entrada entrada;

  public Telefones(List<Telefone> telefones) {
    this.telefones = telefones;
    this.entrada = new Entrada();
  }

  private Telefone newTel() {
    System.out.println("DDD: ");

    String ddd = entrada.receberTexto();

    System.out.println("Número: ");

    String numero = entrada.receberTexto();

    return new Telefone(ddd, numero);
  }

  public void adicionar() {
    Telefone tel = this.newTel();

    this.telefones.add(tel);
  }

  public void editar() {
    int indexTel = entrada.receberNumeroInteiro();

    if (indexTel > telefones.size() || indexTel < 0) {
      System.out.println("\nIndex inválido");
    } else {
      Telefone tel = this.newTel();

      this.telefones.set(indexTel, tel);
    }

  }

  public void remover() {
    int indexTel = entrada.receberNumeroInteiro();

    if (indexTel > telefones.size() || indexTel < 0) {
      System.out.println("\nIndex inválido");
    } else {
      this.telefones.remove(indexTel);
    }
  }
}
