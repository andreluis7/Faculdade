package br.com.quintanoite.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintanoite.dao.FuncionarioDao;
import br.com.quintanoite.domain.Funcionario;
import br.com.quintanoite.util.JsfUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> funcionarios;

	private Funcionario funcionario;

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
	
	public void carregarCadastro() {
		try {
			String valor = JsfUtil.getParam("funCad");
			
			if(valor != null ) {
				Long codigo = Long.parseLong(valor);
				FuncionarioDao funcionarioDao = new FuncionarioDao();
				funcionario = funcionarioDao.buscar(codigo);
			} else {
				funcionario = new Funcionario();
			}
		}catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar !!!");
			e.printStackTrace();
		}
	}

	public void novo() {
		funcionario = new Funcionario();
	}

	public void salvar() {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.salvar(funcionario);
			Messages.addGlobalInfo("Salvo funcionário com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o funcionario");
			erro.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.excluir(funcionario);
			Messages.addGlobalInfo("Funcionário removido com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover o funcionário");
			erro.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.editar(funcionario);
			Messages.addGlobalInfo("Funcionário editado com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editar o funcionário");
			erro.printStackTrace();
		}
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
