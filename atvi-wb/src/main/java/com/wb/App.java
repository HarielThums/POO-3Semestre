package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.Servico;
import com.wb.negocio.Atualizar;
import com.wb.negocio.AtualizarCliente;
import com.wb.negocio.AtualizarProduto;
import com.wb.negocio.AtualizarServico;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Deletar;
import com.wb.negocio.DeletarCliente;
import com.wb.negocio.DeletarProduto;
import com.wb.negocio.DeletarServico;
import com.wb.negocio.Find;
import com.wb.negocio.FindClient;
import com.wb.negocio.FindProduto;
import com.wb.negocio.FindServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosClientesPorGenero;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;

public class App {
	public static void main(String[] args) {
		try {
			System.out.println("\nBem-vindo ao Grupo World Beauty");

			Empresa empresa = new Empresa();
			boolean execucao = true;

			while (execucao) {
				System.out.println("\nQue tipo de opera��o voc� deseja fazer:");
				System.out.println("\nOPERAÇÕES\n");
				System.out.println("1️ - Clientes");
				System.out.println("2️ - Produtos / Serviços");
				System.out.println("3️ - Consumos");
				System.out.println("0 - Sair");

				Entrada entrada = new Entrada();
				int op = entrada.receberNumeroInteiro();

				switch (op) {
					case 0:
						execucao = false;
						break;
					case 1: {
						System.out.println("\n Que tipo de opera��o voc� deseja fazer: \n");
						System.out.println("1 - Listar todos os clientes");
						System.out.println("2 - Listar todos os clientes por genero");
						System.out.println("3 - Cadastrar cliente");
						System.out.println("4 - Atualizar cliente");
						System.out.println("5 - Deletar cliente");
						System.out.println("0 - Sair");

						int clienteOp = entrada.receberNumeroInteiro();

						switch (clienteOp) {
							case 0: {
								execucao = false;

								break;
							}
							case 1: {
								Listagem listagem = new ListarTodosClientes(empresa.getClientes());

								listagem.listar();

								break;
							}
							case 2: {
								Entrada entradaGen = new Entrada();

								System.out.println("\nQue tipo de genero voc� deseja visualizar? (M/F/Outro)");

								String genero = entradaGen.receberTexto();

								Listagem listagem = new ListarTodosClientesPorGenero(empresa.getClientes(), genero);

								listagem.listar();

								break;
							}
							case 3: {
								Cadastro cadastro = new CadastroCliente(empresa.getClientes());

								cadastro.cadastrar();

								break;
							}
							case 4: {
								Find find = new FindClient(empresa.getClientes());

								Cliente cliente = find.find();

								if (cliente == null) {
									System.out.println("\ncliente não registrado");

									break;
								}

								Atualizar atualizar = new AtualizarCliente(cliente);

								atualizar.atualizar();

								break;
							}
							case 5: {
								Find find = new FindClient(empresa.getClientes());

								Cliente cliente = find.find();

								if (cliente == null) {
									System.out.println("\ncliente não registrado");

									break;
								}

								Deletar deletar = new DeletarCliente(empresa.getClientes(), cliente);

								deletar.deletar();

								break;
							}
							default:
								System.out.println("Opera��o n�o entendida");
						}
						break;
					}
					case 2: {
						System.out.println("\n Que tipo de opera��o voc� deseja fazer:");
						System.out.println("1 - Listar todos os produto");
						System.out.println("2 - Listar todos os servico");
						System.out.println("3 - Cadastrar produto");
						System.out.println("4 - Cadastrar servico");
						System.out.println("5 - Atualizar produto");
						System.out.println("6 - Atualizar servico");
						System.out.println("7 - Deletar produto");
						System.out.println("8 - Deletar servico");
						System.out.println("0 - Sair");

						int prodOp = entrada.receberNumeroInteiro();

						switch (prodOp) {
							case 0: {
								execucao = false;

								System.out.println("At� mais!\n");

								break;
							}
							case 1: {
								Listagem listagem = new ListarTodosProdutos(empresa.getProdutos());

								listagem.listar();

								break;
							}
							case 2: {
								Listagem listagem = new ListarTodosServicos(empresa.getServicos());

								listagem.listar();

								break;
							}
							case 3: {
								Cadastro cadastro = new CadastroProduto(empresa.getProdutos());

								cadastro.cadastrar();

								break;
							}
							case 4: {
								Cadastro cadastro = new CadastroServico(empresa.getServicos());

								cadastro.cadastrar();

								break;
							}
							case 5: {
								Find find = new FindProduto(empresa.getProdutos());

								Produto produto = find.find();

								if (produto == null) {
									System.out.println("\nproduto não registrado");

									break;
								}

								Atualizar atualizar = new AtualizarProduto(produto);

								atualizar.atualizar();

								break;
							}
							case 6: {
								Find find = new FindServico(empresa.getServicos());

								Servico servico = find.find();

								if (servico == null) {
									System.out.println("\nservico não registrado");

									break;
								}

								Atualizar atualizar = new AtualizarServico(servico);

								atualizar.atualizar();

								break;
							}
							case 7: {
								Find find = new FindProduto(empresa.getProdutos());

								Produto produto = find.find();

								if (produto == null) {
									System.out.println("\nproduto não registrado");

									break;
								}

								Deletar deletar = new DeletarProduto(empresa.getProdutos(), produto);

								deletar.deletar();

								break;
							}
							case 8: {
								Find find = new FindServico(empresa.getServicos());

								Servico servico = find.find();

								if (servico == null) {
									System.out.println("\nservico não registrado");

									break;
								}

								Deletar deletar = new DeletarServico(empresa.getServicos(), servico);

								deletar.deletar();

								break;
							}

							default:
								System.out.println("Opera��o n�o entendida");
						}
						break;
					}
					case 3: {
						System.out.println("\n Que tipo de opera��o voc� deseja fazer:");
						System.out.println("1 - Cadastrar consumo");
						System.out.println("0 - Sair");

						int prodOp = entrada.receberNumeroInteiro();

						switch (prodOp) {
							case 0: {
								execucao = false;

								System.out.println("At� mais!\n");

								break;
							}
							case 1: {
								Cadastro cadastro = new CadastroConsumo(empresa.getProdutos(), empresa.getServicos(),
										empresa.getClientes(), empresa.getConsumos());

								cadastro.cadastrar();

								break;
							}

							default:
								System.out.println("Opera��o n�o entendida");
						}
						break;
					}
					default:
						System.out.println("Opera��o n�o entendida \n");
				}
			}

		} catch (Exception e) {
			System.out.println("Opera��o n�o entendida \n");
		}
	}
}