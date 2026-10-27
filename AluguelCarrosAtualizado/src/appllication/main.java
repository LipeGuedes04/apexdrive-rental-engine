package appllication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Carro;
import entities.CategoriaCarro;
import entities.Locacao;
import entities.StatusLocacao;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Locacao> contratos = new ArrayList<>();

		int menu = 0;
		System.out.println("======= LOCAÇÂO DE VEÍCULOS =======");

		while (menu != 4) {
			System.out.println("____ MENU _________");
			System.out.println("1 - Novo Contrato \n2 - Listar Contratos \n3 - Encerrar Contrato \n4 - Sair");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				System.out.println("==== Novo Contrato =====");
				System.out.println("Insira o ID do contrato: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Insira o nome do cliente: ");
				String nome = sc.nextLine();
				System.out.println("Insira a categoria do Carro (SEDAN/SUV/ESPORTIVO)");
				CategoriaCarro categoriaCarro = CategoriaCarro.valueOf(sc.nextLine().toUpperCase());
				System.out.println("Insira o Modelo do carro ");
				String modelo = sc.nextLine();
				System.out.println("Insira o preço da diário do veículo: ");
				double preco = sc.nextDouble();
				System.out.println("Insira a quantidade de diarias: ");
				int diaria = sc.nextInt();
				sc.nextLine();

				Carro carro = new Carro(modelo, preco, categoriaCarro);
				Locacao locacao = new Locacao(id, nome, diaria, carro, StatusLocacao.ATIVO);

				contratos.add(locacao);

				break;
			case 2:
				System.out.println("===== Listar Contratos =====");
				if (contratos.isEmpty()) {
					System.out.println("Sistema não possui nenhum contrato");
				} else {
					for (Locacao c : contratos) {
						System.out.println(c);
					}
				}

				break;
			case 3:
				System.out.println("===== Buscar Contrato =====");
				if (contratos.isEmpty()) {
					System.out.println("Sistema não possui nenhum contrato");
				} else {
					System.out.println("Insira o ID do contrato: ");
					int buscarID = sc.nextInt();
					sc.nextLine();

					Locacao EncontrarID = null;
					for (Locacao c : contratos) {
						if (c.getIdContrato() == buscarID) {
							EncontrarID = c;
							if (EncontrarID != null) {

								EncontrarID.setStatus(StatusLocacao.CONCLUIDO);
								System.out.println("Contrato Finalizado com sucesso!! ");

								double Valortotal = EncontrarID.calcularTotal();

								System.out.println("Valor a ser pago: " + Valortotal + "$ Reais");
							}

						} else {
							System.out.println("Não existe esse ID de contrato");
						}

					}
				}

				break;
			case 4:
				System.out.println("Sistema Finalizado");
				break;
			}
		}

		sc.close();

	}

}
