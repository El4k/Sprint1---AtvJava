package questao8;

public class Funcionarios {
	private String nome[];		//Declaração de Array String
	private double salario[];	//Declaração de Array Double
	
	Funcionarios(int quantidade) {	//Construtor de Funcionarios já inicializa com a qntd de Funcionarios
		this.nome = new String[quantidade];		//Inicializando array String dinâmico de acordo com a qntd de Funcionarios
		this.salario = new double[quantidade];	//Inicializando array int dinâmico de acordo com a qntd de Funcionarios
	}
	
	public double getBonificacao(int i) { //Método de Bonificação de acordo com o indicie do Funcionario
		if (this.salario[i] <= 1000) {		//Caso o Funcionário seja um estagiário
			return this.salario[i] * 0.2;
		}
		else if (this.salario[i] > 1000 && this.salario[i] < 2000) {	//Caso o Funcionário seja um Dev Júnior
			return this.salario[i] * 0.1;
		}
		else {	//Caso o Funcionário seja um Dev Sênior
			return this.salario[i] * 0.1;
		}
	}
	
	public void setDados(String nome, double salario, int i) {	//Método que recebe todos os dados de acordo com o índice do Funcionário
		this.nome[i] = nome;	//Atualizando o nome do Funcionário
		this.salario[i] = salario;	//Atualizando o salário do Funcionário
	}
	
	public String getNome(int i) {	//Retornando o nome do Usuário
		return nome[i];
	}
	
	public double getSalario(int i) {	//Retornando o salário do Usuário
		return salario[i];
	}
}