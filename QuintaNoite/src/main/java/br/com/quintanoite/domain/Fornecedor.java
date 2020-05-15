package br.com.quintanoite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends GenericDomain{
	
	private static final long serialVersionUID = 1L;
	@Column(length = 50, nullable = false)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
