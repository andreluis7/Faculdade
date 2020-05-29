package br.com.quintanoite.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;
import br.com.quintanoite.util.JsfUtil;

@ManagedBean
@ViewScoped
public class FornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Fornecedor> fornecedores;

	private Fornecedor fornecedor;

	private String acao;

	@PostConstruct
	public void listar() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedores = fornecedorDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os fornecedores");
			erro.printStackTrace();
		}
	}

	public void carregarCadastro() {
		try {
			acao = JsfUtil.getParam("foracao");
			String valor = JsfUtil.getParam("forCad");

			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FornecedorDao fornecedorDao = new FornecedorDao();
				fornecedor = fornecedorDao.buscar(codigo);
			} else {
				fornecedor = new Fornecedor();
			}
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar !!!");
			e.printStackTrace();
		}
	}

	public void novo() {
		fornecedor = new Fornecedor();
	}

	public void salvar() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.salvar(fornecedor);
			Messages.addGlobalInfo("Salvo fornecedor com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o fornecedor");
			erro.printStackTrace();
		}
	}

	public void excluir() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.excluir(fornecedor);
			Messages.addGlobalInfo("Forncedor removido com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover o fornecedor");
			erro.printStackTrace();
		}
	}

	public void editar() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.editar(fornecedor);
			Messages.addGlobalInfo("Forncedor editado com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editar o fornecedor");
			erro.printStackTrace();
		}
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}
