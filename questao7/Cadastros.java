package questao7;

public class Cadastros {

	private int qntd;
	private String logins[];
	private String senhas[];
	
	Cadastros(int quantidade) {
		this.logins = new String[quantidade];
		this.senhas = new String[quantidade];
		this.qntd = quantidade;
	}
	
	public void setDados(String login, String senha, int indice) {
		this.logins[indice] = login;
		this.senhas[indice] = senha;
	}
	
	public int getDados(String login, String senha) {
		for (int i = 0; i < qntd; i++)
			if (this.logins[i].equals(login) && this.senhas[i].equals(senha))
				return 1;
		return 0;
	}
}