package br.com.quintanoite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Venda extends GenericDomain{
	
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Date hora;
	
	@Column (nullable = false)
	private float total;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	Funcionario funcionario;

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
