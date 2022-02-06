package questao8;

public class Funcionarios {
	private String nome[];		//Declara��o de Array String
	private double salario[];	//Declara��o de Array Double
	
	Funcionarios(int quantidade) {	//Construtor de Funcionarios j� inicializa com a qntd de Funcionarios
		this.nome = new String[quantidade];		//Inicializando array String din�mico de acordo com a qntd de Funcionarios
		this.salario = new double[quantidade];	//Inicializando array int din�mico de acordo com a qntd de Funcionarios
	}
	
	public double getBonificacao(int i) { //M�todo de Bonifica��o de acordo com o indicie do Funcionario
		if (this.salario[i] <= 1000) {		//Caso o Funcion�rio seja um estagi�rio
			return this.salario[i] * 0.2;
		}
		else if (this.salario[i] > 1000 && this.salario[i] < 2000) {	//Caso o Funcion�rio seja um Dev J�nior
			return this.salario[i] * 0.1;
		}
		else {	//Caso o Funcion�rio seja um Dev S�nior
			return this.salario[i] * 0.1;
		}
	}
	
	public void setDados(String nome, double salario, int i) {	//M�todo que recebe todos os dados de acordo com o �ndice do Funcion�rio
		this.nome[i] = nome;	//Atualizando o nome do Funcion�rio
		this.salario[i] = salario;	//Atualizando o sal�rio do Funcion�rio
	}
	
	public String getNome(int i) {	//Retornando o nome do Usu�rio
		return nome[i];
	}
	
	public double getSalario(int i) {	//Retornando o sal�rio do Usu�rio
		return salario[i];
	}
}