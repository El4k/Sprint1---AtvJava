package questao6;

import java.util.Scanner;

public class ProgramaQuiz {
	
	public static void main(String[] args) {
		//Declaração de Variáveis e Declaração do Scanner
		Scanner leEntrada = new Scanner(System.in);
		int alternativa;
		
		System.out.println("Bem-Vindo ao QUIZ!\nTodas as questões devem ser respondidas com o NÚMERO respectivo ao palpite!\n\n");
		System.out.println("Digite aqui o seu nome: ");
		String name = leEntrada.nextLine().replaceAll(" ", ""); //Leitura do Nome (Removendo Espaços)
		
		Quiz quiz = new Quiz(name);	//Inicialização da referência ao Objeto já como o nome do usuário
		System.out.println("_____________________");
		for(int i = 0; i < 3; i++) { //Loop de acordo com a qntd de questões
			try {
				quiz.mostraPergunta(i);	//Mostrando a pergunta ao usuário
				System.out.println("[1] 1\t[2] 2\t[3] 3\t[4] 4");	//Alternativas
				alternativa = leEntrada.nextInt();
				if (alternativa > 0 && alternativa < 5) //Caso o usuário digite algum valor fora do campo (1, 4)
					quiz.analisaResposta(i, alternativa);
				else {
					System.out.println("\nInsira um valor de acordo com as alternativas!");
					i--; //O loop irá retornar com o mesmo indice para repetir a mesma pergunta
				}
			}catch(Exception Ex) { //Caso alguma entrada seja inválida (leitura de String por exemplo)
				System.out.println("\nEntrada Invalida!\n");
				i--; //O loop irá retornar com o mesmo indice para repetir a mesma pergunta
			} finally { //Limpeza de Buffer a cada entrada dentro do loop mesmo caso haja exceção ou não
				leEntrada.nextLine();
			}
		}
		
		quiz.mostraResposta();
		
	}
}