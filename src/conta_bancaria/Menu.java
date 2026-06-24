package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		

		int opcao;
		//criar dados de teste
		criarContasTeste();
        
	
		while (true) {
			
			
			System.out.println(Cores.TEXT_YELLOW + Cores.TEXT_PURPLE
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			 try {
			opcao = leia.nextInt();
             leia.nextLine();
			 }catch(InputMismatchException e) {
				 opcao = -1;
				 System.out.println("Digite um numero inteiro entre 0 e 8");
	
			 }
			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE+ "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				cadastrarConta();
				keyPress();

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				System.out.print(Cores.TEXT_RESET);
               listarContas();
               keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				keyPress();
				
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		} 
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Juliana Vitoria");
		System.out.println("github.com/julianaenob-hub");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	
	}
	
	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
	
	
public static void listarContas() {
	contaController.listarTodas();
}
	
public static void cadastrarConta() {
	System.out.println("Digite o numero da agencia: ");
	int agencia = leia.nextInt();
	leia.nextLine();
	
	System.out.println("Digite o nome do titular da conta: ");
	String titular = leia.nextLine();
		
	System.out.println("Digite o tipo da conta (1- CC | 2 - CP): ");
	int tipo = leia.nextInt();
	leia.nextLine();
	
	System.out.println("Digite o saldo da conta: ");
	float saldo = leia.nextFloat();
	leia.nextLine();
			
			
	switch(tipo){	
	case 1 ->{
		System.out.println("Digite o limite da conta: ");
		float limite = leia.nextFloat();
		
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		
	}
	case 2 ->{ System.out.println("Digite o aniversario da conta: ");
	int aniversario = leia.nextInt();
	
	contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
	
	}
	default -> System.out.println(Cores.TEXT_RED + "Tipo de conta invalida!" + Cores.TEXT_RESET);
	}
	
}

}
