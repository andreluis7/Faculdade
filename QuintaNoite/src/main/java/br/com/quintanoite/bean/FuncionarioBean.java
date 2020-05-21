package br.com.quintanoite.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintanoite.dao.FuncionarioDao;
import br.com.quintanoite.domain.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;

	@PostConstruct
	public void listar() {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();

			funcionarios = funcionarioDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os funcionários");
			erro.printStackTrace();
		}

	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
