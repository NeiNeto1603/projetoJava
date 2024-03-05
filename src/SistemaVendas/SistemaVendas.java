package SistemaVendas;

import java.util.InputMismatchException;

import java.util.Scanner;

public class SistemaVendas {
	static Pedidos pedido;
	static Orcamento orcamento;
	static Veiculo veiculo;
	static Cliente cliente;
	static String marcaVeiculo;
	static String nomeVeiculo;
	static double valorveiculo;
	static String usuario;
	static String senha;
	static Login login;

	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);

	public static void main(String[] args) {
		veiculo = new Veiculo();
		cliente = new Cliente();
		pedido = new Pedidos();
		orcamento = new Orcamento();
		login = new Login();

		boolean logado = false;

		do {

			System.out.println(" _______________________________________");
			System.out.println("|    SISTEMA DE VENDAS DE CARRO        |");
			System.out.println("|______________________________________|");

			System.out.println(" USU�RIO:");
			System.out.println("_________");
			usuario = scan.nextLine();

			System.out.println("SENHA:");
			System.out.println("_________");
			senha = scan.nextLine();

			logado = login.Logar(usuario, senha);

		} while (!logado);
		System.out.println(" _______________________________________ ");
		System.out.println("|     SISTEMA DE VENDAS DE CARRO       | ");
		System.out.println("|______________________________________|");

		System.out.println(" __________________ ");
		System.out.println("|1-VENDER CARRO    |");
		System.out.println("|__________________|");
		System.out.println("|2-FAZER OR�AMENTO |");
		System.out.println("|__________________|");
		System.out.println("|3-SAIR DO SISTEMA |");
		System.out.println("|__________________|");

		int opcao1 = scan.nextInt();

		switch (opcao1) {

		case 1:
			vender();
			break;
		case 2:
			orcamento();
			break;
		default:
			sair();
			break;
		}
		
	}

	private static void orcamento() {
		System.out.println(" __________________ ");
		System.out.println("|                  |");
		System.out.println("|REALIZAR OR�AMENTO|");
		System.out.println("|__________________|");
		int opcao;


		do {
			System.out.println(" _____________________ ");
			System.out.println("|1-INCLUIR CARRO      |");
			System.out.println("|_____________________| ");
			System.out.println("|2-ALTERAR CARRO      |");
			System.out.println("|_____________________| ");
			System.out.println("|3-EXCLUIR CARRO      |");
			System.out.println("|_____________________| ");
			System.out.println("|4-LISTAR CARRO       |");
			System.out.println("|_____________________| ");
			System.out.println("|5-FINALIZAR OR�AMENTO|");
			System.out.println("|_____________________| ");

			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				incluirOrcamento();
				break;
			case 2:
				alterarOrcamento();
				break;
			case 3:
				excluirOrcamento();
				break;
			case 4:
				listarOrcamento();
				break;
			default:
				finalizarOrcamento();
				opcao = 5;
				break;
			}

		} while (opcao != 5);
		

	}

	private static void sair() {

		System.out.println(" CLOSE");

	}

	private static void vender() {
		System.out.println(" __________________ ");
		System.out.println("|                  |");
		System.out.println("| REALIZAR VENDA   |");
		System.out.println("|__________________|");
		int opcao;
		
		do {
			System.out.println(" __________________ ");
			System.out.println("|1-INCLUIR CARRO   |");
			System.out.println("|__________________|");
			System.out.println("|2-ALTERAR CARRO   |");
			System.out.println("|__________________| ");
			System.out.println("|3-EXCLUIR CARRO   |");
			System.out.println("|__________________| ");
			System.out.println("|4-LISTAR CARRO    |");
			System.out.println("|__________________| ");
			System.out.println("|5-FINALIZAR PEDIDO|");
			System.out.println("|__________________| ");

			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				incluirPedido();
				break;
			case 2:
				alterarPedido();
				break;
			case 3:
				excluirPedido();
				break;
			case 4:
				listarPedido();
				break;
			case 5:
				finalizarPedido();
				break;

			default:

				opcao = 6;
				break;

			}

		} while (opcao != 6);
		
	}

	public static void incluirOrcamento() {

		String continuar = "sim";

		
		do {

			try {

				System.out.println(" Informe a marca do Carro:");
				veiculo.setmarca(scan.next());
				System.out.println(" Informe o nome do Carro: ");
				veiculo.setnome (scan.next());
				System.out.println(" Informe o valor do Carro R$: ");
				veiculo.setValor(scan.nextDouble());
				orcamento.adicionarVeiculo(veiculo);
				veiculo = new Veiculo();
				System.out.println("Deseja comprar mais carro ?");
				continuar = scan.next();
			} catch (InputMismatchException erro1) {
				System.out.println(" N�o � permitido inserir letras informe somente n�meros");
				scan.nextLine();
			}

		} while (continuar.equals("sim"));

		
	}

	public static void alterarOrcamento() {
		try {
			System.out.println(" Informe a marca do Carro que deseja alterar");
			marcaVeiculo = scan1.nextLine();
			System.out.println(" Informe o nome do Carro");
			nomeVeiculo = scan1.nextLine();
			System.out.println(" Informe a valor do Carro");
			valorveiculo = scan1.nextDouble();

			Veiculo alterar = new Veiculo();

			alterar.setmarca (marcaVeiculo);
			alterar.setnome  (nomeVeiculo);
			alterar.setValor (valorveiculo);

			orcamento.alterarVeiculo(alterar);

			
		} catch (Exception ex) {

		}

	}

	public static void excluirOrcamento() {
		
			System.out.println("Iforme o Carro que ser� removido");
			marcaVeiculo = scan1.next();
			orcamento.removerVeiculo(marcaVeiculo);

		
	}

	public static void listarOrcamento() {
		System.out.println(" __________________");
		System.out.println("| LISTA DE CARRO|");
		System.out.println("|__________________|");
		for (Veiculo veiculo : orcamento.getListaVeiculos()) {
			System.out.println("Veiculo:" + veiculo.getmarca());
			System.out.println("Nome:" + veiculo.getnome());
			System.out.println("Valor:"+ veiculo.getValor());
		}
	}

	public static void finalizarOrcamento() {
		try {
			System.out.println("Informe o nome do cliente");
			cliente.setNome(scan.next());
			System.out.println(" Informe o telefone do cliente");
			cliente.setTelefone(scan.next());

			System.out.println("VALOR TOTAL DO OR�AMENTO:" + orcamento.getTotal() + " Reais");
			System.out.println("Informe o nome do cliente:" + cliente.getNome());
			System.out.println("Informe o Telefone:" + cliente.getTelefone());
			System.out.println("LISTA DE PEDIDOS " + orcamento.getListaVeiculos());
		} catch (Exception ex) {
			
		}
	}

	//PEDIDO
	
	public static void incluirPedido() {

		String continuar = "sim";
		
		do {

			try {

				System.out.println(" Informe a marca do Carro:");
				veiculo.setmarca(scan.next());
				System.out.println(" Informe o nome do Carro: ");
				veiculo.setnome(scan.next());
				System.out.println(" Informe o valor do Carro R$: ");
				veiculo.setValor(scan.nextDouble());

				pedido.adicionarVeiculo(veiculo);
				
				veiculo = new Veiculo();
				System.out.println("Deseja inserir mais um produto ?");
				continuar = scan.next();

			} catch (InputMismatchException erro1) {
				System.out.println("N�o � permitido inserir letras informe somente n�meros");
				scan.nextLine();
			}

		} while (continuar.equals("sim"));

		
	}

	public static void alterarPedido() {
		try {
			System.out.println(" Informe a marca do Carro que deseja alterar");
			marcaVeiculo = scan1.next();
			System.out.println(" Informe o nome do Carro");
			nomeVeiculo = scan1.next();
			System.out.println(" Informe a valor do Carro");
			valorveiculo = scan1.nextDouble();

			Veiculo alterar = new Veiculo();

			alterar.setmarca(marcaVeiculo);
			alterar.setnome(nomeVeiculo);
			alterar.setValor(valorveiculo);

			pedido.alterarVeiculo(alterar);

			
		} catch (Exception ex) {

		}

	}

	public static void excluirPedido() {
		
			System.out.println("Iforme a marca do carro que ser� removido");
	     	marcaVeiculo = scan1.next();
			pedido.removerVeiculo(marcaVeiculo);
		
		
	}

	public static void listarPedido() {
		System.out.println(" __________________");
		System.out.println("| LISTA DE CARRO   |");
		System.out.println("|__________________|");
		for (Veiculo veiculo : pedido.getListaVeiculos()) {
			System.out.println(" Marca:" + veiculo.getmarca());
			System.out.println(" Nome:" + veiculo.getnome());
			System.out.println(" Valor:" + veiculo.getValor());
		}
	}

	public static void finalizarPedido() {

		System.out.println("Informe o nome do cliente");
		cliente.setNome(scan.next());
		System.out.println(" Informe o telefone do cliente");
		cliente.setTelefone(scan.next());

		System.out.println("O VALOR TOTAL DO PEDIDO �:" + pedido.getTotal() + " REAIS");
		System.out.println("CLIENTE:" + cliente.getNome());
		System.out.println("Telefone:" + cliente.getTelefone());
		System.out.println("CARROS COMPRADOS \n " + pedido.getListaVeiculos());

	}

	

}
