package questao6;

import java.util.Scanner;

public class ProgramaQuiz {
	
	public static void main(String[] args) {
		//Declara��o de Vari�veis e Declara��o do Scanner
		Scanner leEntrada = new Scanner(System.in);
		int alternativa;
		
		System.out.println("Bem-Vindo ao QUIZ!\nTodas as quest�es devem ser respondidas com o N�MERO respectivo ao palpite!\n\n");
		System.out.println("Digite aqui o seu nome: ");
		String name = leEntrada.nextLine().replaceAll(" ", ""); //Leitura do Nome (Removendo Espa�os)
		
		Quiz quiz = new Quiz(name);	//Inicializa��o da refer�ncia ao Objeto j� como o nome do usu�rio
		System.out.println("_____________________");
		for(int i = 0; i < 3; i++) { //Loop de acordo com a qntd de quest�es
			try {
				quiz.mostraPergunta(i);	//Mostrando a pergunta ao usu�rio
				System.out.println("[1] 1\t[2] 2\t[3] 3\t[4] 4");	//Alternativas
				alternativa = leEntrada.nextInt();
				if (alternativa > 0 && alternativa < 5) //Caso o usu�rio digite algum valor fora do campo (1, 4)
					quiz.analisaResposta(i, alternativa);
				else {
					System.out.println("\nInsira um valor de acordo com as alternativas!");
					i--; //O loop ir� retornar com o mesmo indice para repetir a mesma pergunta
				}
			}catch(Exception Ex) { //Caso alguma entrada seja inv�lida (leitura de String por exemplo)
				System.out.println("\nEntrada Invalida!\n");
				i--; //O loop ir� retornar com o mesmo indice para repetir a mesma pergunta
			} finally { //Limpeza de Buffer a cada entrada dentro do loop mesmo caso haja exce��o ou n�o
				leEntrada.nextLine();
			}
		}
		
		quiz.mostraResposta();
		
	}
}