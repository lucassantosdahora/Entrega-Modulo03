package com.agenciadeviagem.principal;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Scanner;

import com.agenciadeviagem.DAO.ClientesDAO;
import com.agenciadeviagem.DAO.DestinosDAO;
import com.agenciadeviagem.DAO.PromocoesDAO;
import com.agenciadeviagem.DAO.ReservasDAO;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ClientesDAO clientesDAO = new ClientesDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		PromocoesDAO promocoesDAO = new PromocoesDAO();
		ReservasDAO reservasDAO = new ReservasDAO();

		while (true) {
			System.out.println("\n");
			System.out.println("**********************************************");
			System.out.println("   Console de Cadastro Agênia de viagens     *");
			System.out.println("**********************************************");
			System.out.println("\n");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("1. Registrar Clientes                           |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("2. Listar Clientes                              |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("3. Atualizar Clientes                           |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("4. Excluir Clientes                             |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("5. Registrar Destinos                           |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("6. Listar Destinos                              |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("7. Atualizar Destinos                           |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("8. Excluir Destinos                             |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("9. Registrar Promoção                           |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("10. Listar Promoção                             |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("11. Atualizar Promoção                          |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("12. Excluir Promoção                            |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("13. Gerar Reserva                               |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("14. Listar Reserva                              |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("15. Atualizar Reseva                            |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("16. Excluir Reserva                             |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("  17. Sair                                      |");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("\n");
			System.out.println("**********************************************");
			System.out.println("             Escolha uma opção:              *");
			System.out.println("**********************************************");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				// Registrar clientes
				Clientes clientes = new Clientes();
				System.out.println("Nome do cliente:");
				scanner.nextLine();
				clientes.setNome(scanner.nextLine());
				System.out.println("Cpf do cliente:");
				clientes.setCpf(scanner.nextLine());
				System.out.println("Telefone do cliente:");
				clientes.setTelefone(scanner.nextLine());
				System.out.println("Idade do cliente:");
				clientes.setIdade(scanner.nextInt());
				scanner.nextLine(); // Consumir a nova linha após o número inteiro
				System.out.println("Residencia do cliente:");
				clientes.setEndereco(scanner.nextLine());
				clientesDAO.registrarClientes(clientes);
				System.out.println("Cliente Registrado");
				break;

			case 2:
				// Lista clientes
				List<Clientes> Clientes = clientesDAO.listaClientes();
				System.out.println("Lista de clientes:");
				for (Clientes e : Clientes) {
					System.out.println("ID: " + e.getId() + ", Nome: " + e.getNome() + ", Idade: " + e.getIdade()
							+ ", Cpf: " + e.getCpf() + ", Endereço: " + e.getEndereco());
				}
				break;

			case 3:
				// Atualizar clientes
				System.out.print("ID do cliente para atualização: ");
				int clientesIdAtualizar = scanner.nextInt();
				scanner.nextLine(); // Consumir a quebra de linha pendente
				Clientes clientesAtualizar = clientesDAO.buscarClientes(clientesIdAtualizar);
				if (clientesAtualizar != null) {
					System.out.println("Nome do cliente:");
					clientesAtualizar.setNome(scanner.nextLine());
					System.out.println("Cpf do cliente:");
					clientesAtualizar.setCpf(scanner.nextLine());
					System.out.println("Telefone do cliente:");
					clientesAtualizar.setTelefone(scanner.nextLine());
					System.out.println("Idade do cliente:");
					clientesAtualizar.setIdade(scanner.nextInt());
					scanner.nextLine(); // Consumir a quebra de linha pendente
					System.out.println("Residência do cliente:");
					clientesAtualizar.setEndereco(scanner.nextLine());
					clientesDAO.atualizarRegistroCliente(clientesAtualizar);
					System.out.println("Cliente atualizado com sucesso!");
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;

			case 4:
				// Excluir cliente
				System.out.print("ID do cliente para exclusão: ");
				int clientesIdExcluir = scanner.nextInt();
				Clientes clientesExcluir = clientesDAO.buscarClientes(clientesIdExcluir);
				if (clientesExcluir != null) {
					clientesDAO.excluirRegistroClientes(clientesIdExcluir);
					System.out.println("Cliente excluído com sucesso!");
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;

			case 5:
				// Registar destinos
				Destinos destinos = new Destinos();
				System.out.println("Nome do destino:");
				scanner.nextLine();
				destinos.setNome(scanner.nextLine());
				System.out.println("Infome a descrição:");
				destinos.setDescricao(scanner.nextLine());
				System.out.println("Nome do país:");
				destinos.setPais(scanner.nextLine());
				destinosDAO.registrarDestinos(destinos);
				System.out.println("Destino registrado com Sucesso!");
				break;

			case 6:
				// Lista Destinos
				List<Destinos> Destinos = destinosDAO.listaDestinos();
				System.out.println("Lista de destinos:");
				for (Destinos e : Destinos) {
					System.out.println("id: " + e.getId() + ", Nome: " + e.getNome() + ", Descrição: "
							+ e.getDescricao() + ", País: " + e.getPais());
				}
				break;
			case 7:
				// Atualizar Destinos
				System.out.print("ID do destino para atualização: ");
				int destinosIdAtualizar = scanner.nextInt();
				Destinos destinosAtualizar = destinosDAO.buscarDestinos(destinosIdAtualizar);
				if (destinosAtualizar != null) {
					System.out.println("Nome do destino:");
					scanner.nextLine();
					destinosAtualizar.setNome(scanner.nextLine());
					System.out.println("Descrição do Destino:");
					destinosAtualizar.setDescricao(scanner.nextLine());
					System.out.println("País do destino:");
					destinosAtualizar.setPais(scanner.nextLine());
					destinosDAO.atualizarDestinos(destinosAtualizar);
					System.out.println("Destino atualizado com sucesso!");
				} else {
					System.out.println("Destino não encontrado.");
				}
				break;

			case 8:
				// Excluir Destinos
				System.out.print("ID do destino para exclusão: ");
				int DestinosIdExcluir = scanner.nextInt();
				Destinos DestinosExcluir = destinosDAO.buscarDestinos(DestinosIdExcluir);
				if (DestinosExcluir != null) {
					destinosDAO.excluirRegistroDestinos(DestinosIdExcluir);
					System.out.println("Destino excluído com sucesso!");
				} else {
					System.out.println("Destino não encontrado.");
				}
				break;

			case 9:
				// Registrar promoções
				Promocoes promocoes = new Promocoes();
				System.out.println("Nome da promoção:");
				scanner.nextLine();
				promocoes.setNome(scanner.nextLine());
				System.out.println("Informe o valor de desconto:");
				int desconto = scanner.nextInt();
				promocoes.setDesconto(desconto);
				System.out.println("Id do Destino:");
				int DestinoId = scanner.nextInt();
				Destinos destinoPromocao = destinosDAO.buscarDestinos(DestinoId);
				if (destinoPromocao != null) {
					promocoes.setDestinos(destinoPromocao);
					System.out.print("Data de validade (dd/MM/yyyy): ");
					String dataValidade = scanner.next();
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date dataInicializada = new Date(sdf.parse(dataValidade).getTime());
						promocoes.setDataValidade(dataInicializada);
						promocoesDAO.registroPromocoes(promocoes);
						System.out.println("Promoção cadastrada com sucesso!");
					} catch (ParseException e) {
						System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
					}
				} else {
					System.out.println("Destino não encontrado.");
				}
				break;

			case 10:
				// Lista promoções
				List<Promocoes> promocoesList = promocoesDAO.listaPromocoes();
				System.out.println("Lista de promoções:");
				for (Promocoes promo : promocoesList) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String dataInicioFormatada = dateFormat.format(promo.getDataValidade());
					System.out.println("ID: " + promo.getId() + ", Nome da promoção: " + promo.getNome()
							+ ", viculado ao destino: " + promo.getDestinos().getNome() + ", Data de validade: "
							+ dataInicioFormatada + ", Desconto: " + promo.getDesconto() + "R$");
				}
				break;

			case 11:
				// Atualizar Promoções
				System.out.print("ID da Promoção para atualização: ");
				int promocaoId = scanner.nextInt();
				Promocoes promocaoAtualizar = promocoesDAO.buscarPromocoes(promocaoId);

				if (promocaoAtualizar != null) {
					System.out.println("Nome da promoção:");
					scanner.nextLine();
					promocaoAtualizar.setNome(scanner.nextLine());
					System.out.println("Informe o valor de desconto:");
					int desconto1 = scanner.nextInt();
					promocaoAtualizar.setDesconto(desconto1);

					System.out.println("ID do Destino:");
					int destinoIdAtualizar = scanner.nextInt();
					Destinos destinoPromocaoAtualizar = destinosDAO.buscarDestinos(destinoIdAtualizar);

					if (destinoPromocaoAtualizar != null) {
						promocaoAtualizar.setDestinos(destinoPromocaoAtualizar);
						System.out.print("Data de validade (dd/MM/yyyy): ");
						String dataValidade = scanner.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataInicializada = new Date(sdf.parse(dataValidade).getTime());
							promocaoAtualizar.setDataValidade(dataInicializada);
							promocoesDAO.atualizarPromocoes(promocaoAtualizar);
							System.out.println("Promoção atualizada com sucesso!");

						} catch (ParseException e) {
							System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
						}
					} else {
						System.out.println("Destino não encontrado.");
					}
				} else {
					System.out.println("Promoção não encontrada.");
				}
				break;

			case 12:
				// Excluir promoções
				System.out.print("ID da promoção para exclusão: ");
				int promocaoIdExcluir = scanner.nextInt();
				Promocoes promocaoExcluir = promocoesDAO.buscarPromocoes(promocaoIdExcluir);
				if (promocaoExcluir != null) {
					promocoesDAO.excluirPromocao(promocaoIdExcluir);
					System.out.println("Promoção excluída com sucesso!");
				} else {
					System.out.println("Promoção não encontrada.");
				}
				break;

			case 13:
				// Gerar reserva
				Reservas reservas = new Reservas();
				System.out.print("ID do Cliente: ");
				int clienteId = scanner.nextInt();
				Clientes reservaClinte = clientesDAO.buscarClientes(clienteId);
				if (reservaClinte != null) {
					reservas.setClientes(reservaClinte);
					System.out.print("ID do destino: ");
					int destinoId = scanner.nextInt();
					Destinos reservaDestino = destinosDAO.buscarDestinos(destinoId);
					if (reservaDestino != null) {
						reservas.setDestinos(reservaDestino);
						System.out.println("Infome valot total a pagar:");
						reservas.setValor(scanner.nextInt());
						System.out.print(" Data da reserva (dd/mm/yyyy): ");
						String dataReserva = scanner.next();
						try {
							// Converter a data fornecida em um objeto java.sql.Date
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							java.util.Date dataReservada = sdf.parse(dataReserva);
							java.sql.Date sqlDate = new java.sql.Date(dataReservada.getTime());
							// Definir a data da reserva
							reservas.setDataReserva(sqlDate);
							reservasDAO.registrarReservas(reservas);
							System.out.println("Reserva gerada com sucesso!");

						} catch (ParseException e) {
							System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
						}
					} else {
						System.out.println("Destino não encontrado.");
					}
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;

			case 14:
				// Lista Reserva
				List<Reservas> Reservas = reservasDAO.listaReservas();
				System.out.println("Lista de Reservas:");
				for (Reservas e : Reservas) {
					System.out.println("ID: " + e.getId() + ", Cliente: " + e.getClientes().getNome() + ", destino: "
							+ e.getDestinos().getNome() + ", data da reserva: " + e.getDataReserva()
							+ ", Valor total a pagar: " + e.getValor() + "R$");
				}
				break;

			case 15:
				// Atualizar reserva
				System.out.print("ID da reserva para atualização: ");
				int reservaId = scanner.nextInt();
				Reservas reservaAtualizar = reservasDAO.buscarReservas(reservaId);
				if (reservaAtualizar != null) {
					System.out.print("ID do Cliente: ");
					int clienteIdAtualizar = scanner.nextInt();
					Clientes reservaClienteAtualizar = clientesDAO.buscarClientes(clienteIdAtualizar);
					if (reservaClienteAtualizar != null) {
						reservaAtualizar.setClientes(reservaClienteAtualizar);
						System.out.print("ID do destino: ");
						int destinoId = scanner.nextInt();
						Destinos reservaDestino = destinosDAO.buscarDestinos(destinoId);
						if (reservaDestino != null) {
							reservaAtualizar.setDestinos(reservaDestino);
							// Solicitar o valor total a pagar
							System.out.println("Informe valor total a pagar:");
							int valorTotal = scanner.nextInt();
							reservaAtualizar.setValor(valorTotal);
							System.out.print("Data da reserva (dd/mm/yyyy): ");
							String dataReserva = scanner.next();
							try {
								// Converter a data fornecida em um objeto java.sql.Date
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								java.util.Date dataReservada = sdf.parse(dataReserva);
								java.sql.Date sqlDate = new java.sql.Date(dataReservada.getTime());

								// Definir a data da reserva
								reservaAtualizar.setDataReserva(sqlDate);

								// Atualizar a reserva
								reservasDAO.atualizarReservas(reservaAtualizar);
								System.out.println("Reserva atualizada com sucesso!");
							} catch (ParseException e) {
								System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
							}
						} else {
							System.out.println("Destino não encontrado.");
						}
					} else {
						System.out.println("Cliente não encontrado.");
					}
				} else {
					System.out.println("Reserva não encontrada.");
				}
				break;

			case 16:
				// Excluir Reserva
				System.out.print("ID da reserva para exclusão: ");
				int reservaIdExcluir = scanner.nextInt();
				Reservas reservaExcluir = reservasDAO.buscarReservas(reservaIdExcluir);
				if (reservaExcluir != null) {
					reservasDAO.excluirReserva(reservaIdExcluir);
					System.out.println("Reserva excluída com sucesso!");
				} else {
					System.out.println("Reserva não encontrada.");
				}
				break;

			case 17:
				// Sair
				System.out.println("Saindo do sistema...");
				clientesDAO.fecharConexao();
				destinosDAO.fecharConexao();
				promocoesDAO.fecharConexao();
				reservasDAO.fecharConexao();
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;

			}

		}
	}

}
