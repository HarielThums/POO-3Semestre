package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nIn�cio do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");

		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o nome social do cliente:");

		String nomeSocial = entrada.receberTexto();

		System.out.println("Por favor informe o n�mero do cpf:");

		String valor = entrada.receberTexto();

		System.out.println("Por favor informe a data de emiss�o do cpf, no padr�o dd/mm/yyyy:");

		String data = entrada.receberTexto();

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);

		CPF cpf = new CPF(dataEmissao, valor);

		System.out.println("Por favor informe o gênero (M/F/Outro):");

		String genero = entrada.receberTexto();

		Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);

		System.out.println("Por favor informe um telefone: ");

		Telefones cadastroTelefone = new Telefones(cliente.getTelefones());

		cadastroTelefone.adicionar();

		boolean whileTelefones = true;
		while (whileTelefones) {
			System.out.println("\nQual operação deseja realizar? ");
			System.out.println("1 - Adicionar outro telefone");
			System.out.println("0 - sair");

			int operacaoTel = entrada.receberNumeroInteiro();

			switch (operacaoTel) {
				case 0: {
					whileTelefones = false;

					break;
				}
				case 1: {
					Telefones telefone = new Telefones(cliente.getTelefones());

					telefone.adicionar();

					break;
				}
				default:
					System.out.println("Opera��o n�o entendida \n");
			}
		}

		this.clientes.add(cliente);
	}
}