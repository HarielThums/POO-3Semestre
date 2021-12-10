package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class FindServico extends Find {
  private List<Servico> servicos;
  private Servico servico;

  public FindServico(List<Servico> servicos) {
    this.servicos = servicos;
  }

  @Override
  public Servico find() {
    Entrada entrada = new Entrada();

    System.out.println("\nInsira o nome do produto: ");

    String nome = entrada.receberTexto();

    for (Servico v : servicos) {
      if (v.nome.equals(nome))
        this.servico = v;
    }

    return this.servico;
  }
}
