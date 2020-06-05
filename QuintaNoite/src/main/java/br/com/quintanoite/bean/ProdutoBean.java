package br.com.quintanoite.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.dao.ProdutoDao;
import br.com.quintanoite.domain.Fornecedor;
import br.com.quintanoite.domain.Produto;
import br.com.quintanoite.util.JsfUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;

	// responsável por popular o selectOneMenu
	private List<Fornecedor> fornecedores;

	private Produto produto;

	private String acao;

	@PostConstruct
	public void listar() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtos = produtoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os produtos");
			erro.printStackTrace();
		}

	}

	public void carregarCadastro() {
		try {

			acao = JsfUtil.getParam("proAcao");
			String valor = JsfUtil.getParam("proCad");

			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				ProdutoDao produtoDao = new ProdutoDao();
				produto = produtoDao.buscar(codigo);
			} else {
				produto = new Produto();
			}

			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedores = fornecedorDao.listar();

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar !!!");
			e.printStackTrace();
		}
	}

	public void novo() {
		try {
			produto = new Produto();
			
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedores = fornecedorDao.listar();
			
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar !!!");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.salvar(produto);
			Messages.addGlobalInfo("Salvo produto com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o produto");
			erro.printStackTrace();
		}
	}

	public void excluir() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.excluir(produto);
			Messages.addGlobalInfo("Produto removido com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover o produto");
			erro.printStackTrace();
		}
	}

	public void editar() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.editar(produto);
			Messages.addGlobalInfo("Produto editado com sucesso!!!");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao editar o produto");
			erro.printStackTrace();
		}
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

}
