package questao8;

import java.util.Scanner;

public class ProgramaBonificacao {

	public static void main(String[] args) {
		//Declação de Variáveis e Declaração do Scanner
		Scanner leEntrada = new Scanner(System.in);
		String name = null;
		double salary = 0;
		int qntdFuncionario = 0;
		
		try {
			do {
				System.out.println("Digite a quantidade de Funcionários da sua empresa: ");
				qntdFuncionario = leEntrada.nextInt();
				if (qntdFuncionario <= 0)	
					System.out.println("\nDigite um valor inteiro positivo!\n");
			}while(qntdFuncionario <= 0); //O programa entrará em loop caso o número de Funcionários seja negativo
		}catch(Exception Ex) {	//O programa entrará em loop caso o tipo de entrada seja inválido
			System.out.println("Entrada Inválida!\n");
			main(args);
		}
		
		Funcionarios Func = new Funcionarios(qntdFuncionario); //Declarando a referência do Objeto já com a qntd de Funcionários
		
		for (int i = 0; i < qntdFuncionario; i++) {
			
			try {
				System.out.println("\nDigite o nome do Funcionario: [" + (i+1) + "]: ");
				name = leEntrada.next().replaceAll(" ", ""); //Recebendo o nome do Funcionário e removendo espaços
				
				leEntrada.nextLine(); //Limpando o Buffer
				
				System.out.println("\nDigite o salário do Funcionário: [" + (i+1) + "]: ");
				salary = leEntrada.nextDouble();	//Recebendo o salário do Funcionário
				
				if (salary <= 0) {	//Caso o Usuário insira um salário negativo
					System.out.println("\nDigite um salario positivo!\n");
					i--;	//O loop retornará ao mesmo indíce que gerou erro
				}
				
			} catch(Exception Ex) { //O programa entrará em loop caso o tipo de entrada seja inválido
				System.out.println("\nEntrada Invalida!\n");
				i--;	//O loop retornará ao mesmo índice que gerou erro
			} finally {	//Limpeza de Buffer a cada entrada dentro do loop mesmo caso haja exceção ou não
				leEntrada.nextLine();
			}
			
			Func.setDados(name, salary, i);
		}
		
		for (int i = 0; i < qntdFuncionario; i++) {	//Loop para mostrar os dados de todos os funcionários
			System.out.println("\n\nMostrando os dados do funcionario [" + (i+1) + "]\n");
			System.out.println("Nome: " + Func.getNome(i));
			System.out.println("Salario: " + Func.getSalario(i));
			if (Func.getSalario(i) > 2000) { //Caso o Usuário seja um Dev Sênior
				System.out.println("Desconto: " + (Func.getBonificacao(i)));
				System.out.println("Salario Liquido: " + (Func.getSalario(i)-Func.getBonificacao(i)));
			}
			else {	//Caso o Usuário seja um Estagiário ou um Dev Júnior
				System.out.println("Bonificação: " + Func.getBonificacao(i));
				System.out.println("Salario Liquido: " + (Func.getBonificacao(i)+Func.getSalario(i)));
			}
		}
		
	}
}