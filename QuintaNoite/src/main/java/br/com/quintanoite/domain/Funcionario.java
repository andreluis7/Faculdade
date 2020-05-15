package br.com.quintanoite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends GenericDomain{
	
	private static final long serialVersionUID = 1L;

	@Column (length = 50, nullable = false)
	private String nome;	
	
	@Column (length = 14, nullable = false)
	private String cpf;	
	
	@Column (length = 20, nullable = false)
	private String senha;	
	
	@Column (length = 30, nullable = false)
	private String funcao;
	
	//getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
