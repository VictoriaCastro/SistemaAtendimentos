package Codigo;

import java.io.Serializable;

public class Senha implements Serializable {

	private static final long serialVersionUID = 7996576305759239287L;

	public String nome;
	public String prioritario;
	public int senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrioritario() {
		return prioritario;
	}

	public void setPrioritario(String prioritario) {
		this.prioritario = prioritario;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Senha(String nome, String prioritario) {
		this.nome = nome;
		this.prioritario = prioritario;
	}

}
