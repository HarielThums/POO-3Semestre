package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Servico;


public class DeletarServico extends Deletar {
  private Servico servico;
  private List<Servico> servicos;

  public DeletarServico(List<Servico> servicos, Servico servico) {
    this.servicos = servicos;
    this.servico = servico;
  }

  @Override
  public void deletar() {
    this.servicos.remove(this.servico);
  }

}
