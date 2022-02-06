package questao7;

import java.util.Calendar;
import java.util.Scanner;

public class ProgramaHoras {
	
	public static void main(String[] args) {
		
		//Declarando Scanner e Vari�veis
		Scanner Leitura = new Scanner(System.in);
		int qntdFuncionarios = 0, sair = 0;
		String login = null, senha = null;
		
		//Captura de Erros (Caso a entrada n�o seja um n�mero positivo)
		try {
			do {
				System.out.println("Quantos funcionarios tem sua empresa? ");
				qntdFuncionarios = Leitura.nextInt();
				if (qntdFuncionarios <= 0)
					System.out.println("\nDigite um valor maior que ZERO!\n");
			}while(qntdFuncionarios <= 0);
		}catch(Exception ex) {
			System.out.println("Digite uma entrada valida!\n");
			ProgramaHoras.main(args);
		}
		
		//Cria��o dos Funcion�rios
		Cadastros cads = new Cadastros(qntdFuncionarios);
		
		for (int i = 0; i < qntdFuncionarios; i++) {

			Leitura.nextLine(); //Limpa Buffer
			System.out.println("\nDigite o login do Funcionario " + (i+1) + ": ");
			login = Leitura.next().replaceAll(" ", ""); //Entrada de String (REMOVENDO ESPA�OS)
			
			Leitura.nextLine(); //Limpa Buffer
			
			System.out.println("Digite a senha do Funcionario " + (i+1) + ": ");
			senha = Leitura.next().replaceAll(" ", ""); //Entrada de String (REMOVENDO ESPA�OS)

			cads.setDados(login, senha, i);
		}

		//M�todo de Entrada dos Usu�rios
		while (sair == 0) {

			System.out.println("___________________\nEntrando no Sistema!\n___________________\n");
			
			Leitura.nextLine(); //Limpa Buffer
			
			System.out.println("Digite o login: ");
			login = Leitura.next().replace(" ", ""); //Entrada de String (REMOVENDO ESPA�OS)

			Leitura.nextLine(); //Limpa Buffer
			
			System.out.println("Digite a senha: ");
			senha = Leitura.next().replace(" ", ""); //Entrada de String (REMOVENDO ESPA�OS)
			
			if (cads.getDados(login, senha) == 1) {
				mostraHora();
					sair = 1;
			} else {
				System.out.println("Usuario e/ou senha incorretos.");
			}

		}
		
		System.out.println("\n\nObrigado pela sua visita!");
	}
	
	public static void mostraHora() { //M�todo para mostrar a hora
		
		Calendar calendario = Calendar.getInstance(); //Instanciando Calendar da biblioteca importada
		int horas = calendario.get(Calendar.HOUR_OF_DAY); //Obtendo as horas atr�ves da refer�ncia correta
		
		//Mostrando ao usu�rio uma mensagem de boas vindas de acordo com o hor�rio do computador
		if (horas >= 6 && horas < 12) {
			System.out.println("\nBom dia, voce se logou ao nosso sistema");
		}
		
		else if (horas >= 12 && horas < 18) {
			System.out.println("\nBoa tarde, voce se logou ao nosso sistema");
		}
		
		else if (horas >= 18 && horas < 24) {
			System.out.println("\nBoa noite, voce se logou ao nosso sistema");
		}
		
		else {
			System.out.println("\nBoa madrugada, voce se logou ao nosso sistema");
		}
	}
	
}