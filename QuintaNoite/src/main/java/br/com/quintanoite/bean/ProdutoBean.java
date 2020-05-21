package br.com.quintanoite.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.quintanoite.dao.ProdutoDao;
import br.com.quintanoite.domain.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;

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

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
