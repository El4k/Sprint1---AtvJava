package questao8;

import java.util.Scanner;

public class ProgramaBonificacao {

	public static void main(String[] args) {
		//Decla��o de Vari�veis e Declara��o do Scanner
		Scanner leEntrada = new Scanner(System.in);
		String name = null;
		double salary = 0;
		int qntdFuncionario = 0;
		
		try {
			do {
				System.out.println("Digite a quantidade de Funcion�rios da sua empresa: ");
				qntdFuncionario = leEntrada.nextInt();
				if (qntdFuncionario <= 0)	
					System.out.println("\nDigite um valor inteiro positivo!\n");
			}while(qntdFuncionario <= 0); //O programa entrar� em loop caso o n�mero de Funcion�rios seja negativo
		}catch(Exception Ex) {	//O programa entrar� em loop caso o tipo de entrada seja inv�lido
			System.out.println("Entrada Inv�lida!\n");
			main(args);
		}
		
		Funcionarios Func = new Funcionarios(qntdFuncionario); //Declarando a refer�ncia do Objeto j� com a qntd de Funcion�rios
		
		for (int i = 0; i < qntdFuncionario; i++) {
			
			try {
				System.out.println("\nDigite o nome do Funcionario: [" + (i+1) + "]: ");
				name = leEntrada.next().replaceAll(" ", ""); //Recebendo o nome do Funcion�rio e removendo espa�os
				
				leEntrada.nextLine(); //Limpando o Buffer
				
				System.out.println("\nDigite o sal�rio do Funcion�rio: [" + (i+1) + "]: ");
				salary = leEntrada.nextDouble();	//Recebendo o sal�rio do Funcion�rio
				
				if (salary <= 0) {	//Caso o Usu�rio insira um sal�rio negativo
					System.out.println("\nDigite um salario positivo!\n");
					i--;	//O loop retornar� ao mesmo ind�ce que gerou erro
				}
				
			} catch(Exception Ex) { //O programa entrar� em loop caso o tipo de entrada seja inv�lido
				System.out.println("\nEntrada Invalida!\n");
				i--;	//O loop retornar� ao mesmo �ndice que gerou erro
			} finally {	//Limpeza de Buffer a cada entrada dentro do loop mesmo caso haja exce��o ou n�o
				leEntrada.nextLine();
			}
			
			Func.setDados(name, salary, i);
		}
		
		for (int i = 0; i < qntdFuncionario; i++) {	//Loop para mostrar os dados de todos os funcion�rios
			System.out.println("\n\nMostrando os dados do funcionario [" + (i+1) + "]\n");
			System.out.println("Nome: " + Func.getNome(i));
			System.out.println("Salario: " + Func.getSalario(i));
			if (Func.getSalario(i) > 2000) { //Caso o Usu�rio seja um Dev S�nior
				System.out.println("Desconto: " + (Func.getBonificacao(i)));
				System.out.println("Salario Liquido: " + (Func.getSalario(i)-Func.getBonificacao(i)));
			}
			else {	//Caso o Usu�rio seja um Estagi�rio ou um Dev J�nior
				System.out.println("Bonifica��o: " + Func.getBonificacao(i));
				System.out.println("Salario Liquido: " + (Func.getBonificacao(i)+Func.getSalario(i)));
			}
		}
		
	}
}