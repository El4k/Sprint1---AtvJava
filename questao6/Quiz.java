package questao6;

public class Quiz {
	
	private String nome;		//Nome do Usuário
	private String[] perguntas;	//Declaração de Array String
	private int[] respostas;	//Declaração de Array int
	private static int acerto;	//Contador de Acertos
	private static int erro;	//Contador de Erros
	
	public Quiz(String name) {	//Construtor, classe já inicializa com o nome do Usuário
		this.nome = name;
		this.perguntas = new String[3];	//Inicializando Array(String) com seu tamanho
		this.respostas = new int[3];	//Inicializando Array(int) com seu tamanho
		this.perguntas[0] = "Quantos estados tem a região SUDESTE do Brasil?";	//Pergunta 1
		this.respostas[0] = 4;													//Resposta 1
		this.perguntas[1] = "Quantos Emilio's existem entre os estagiarios?";	//Pergunta 2
		this.respostas[1] = 1;													//Resposta 2
		this.perguntas[2] = "Quantas xicaras de cafe sao recomendadas em 1 dia?";	//Pergunta 3
		this.respostas[2] = 3;														//Resposta 3
	}
	
	public void mostraResposta() { 						//Resposta Final ao Usuário
		System.out.println("\n_____________________");
		System.out.println("Usuario: " + this.nome);	//Nome do Usuário
		System.out.println("Acertos: " + Quiz.acerto);	//Quantidade de Acertos
		System.out.println("Erros: " + Quiz.erro);		//Quantidade de Erros
		System.out.println("_____________________");
	}
	
	public void mostraPergunta(int i) {					//Método para mostrar ao usuário a pergunta a ser respondida
		System.out.println(this.perguntas[i]);
	}
	
	public void analisaResposta(int i, int alternativa) {	//Método para analisar a resposta
		if (alternativa == this.respostas[i]) {
			System.out.println("\nVoce acertou!");
			System.out.println("_____________________");
			Quiz.acerto++;
		} else {
			System.out.println("\nVoce errou!");
			System.out.println("_____________________");
			Quiz.erro++;
		}
	}
}