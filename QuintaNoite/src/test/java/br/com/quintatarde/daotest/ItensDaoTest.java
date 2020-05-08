package br.com.quintatarde.daotest;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.quintanoite.dao.ItemDao;
import br.com.quintanoite.dao.ProdutoDao;
import br.com.quintanoite.dao.VendaDao;
import br.com.quintanoite.domain.Item;
import br.com.quintanoite.domain.Produto;
import br.com.quintanoite.domain.Venda;

public class ItensDaoTest {

	@Test
	@Ignore
	public void Salvar() {
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		Produto produto = produtoDao.buscar(1L);
		
		VendaDao vendasDao = new VendaDao();
		
		Venda vendas = vendasDao.buscar(1L);
		
		

		Item iten = new Item();// Instancia��o de objeto referente aos itens, para salvar no banco
													// de dados

		iten.setQtd (6);
		iten.setValorParc(110.00f);// Preenchimento do campo respectivo � tabela 'Itens'
		iten.setProd(produto);
		iten.setVenda(vendas);
		
		ItemDao itenDao = new ItemDao();// Realiza��o da inser��o no banco de dados
		itenDao.salvar(iten);

		System.out.println("Exito no cadastro do iten");// mensagem de sucesso, imprimir.
	}

	@Test
	//@Ignore
	public void listar() {

		ItemDao itensDao = new ItemDao();
		List<Item> resultado = itensDao.listar();

		System.out.println("Total de registros: " + resultado.size());

		for (Item itens : resultado) {
			System.out.println(itens.getQtd());
			System.out.println(itens.getValorParc());
			System.out.println(itens.getProd());
			System.out.println(itens.getVenda());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 5L;

		ItemDao itensDao = new ItemDao();
		Item itens = itensDao.buscar(codigo);

		if (itens == null) {
			System.out.println("Nenhum registro encontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(itens.getQtd());
		}

	}

	@Test
	@Ignore

	public void excluir() {
		Long codigo = 7L;
		ItemDao itensDao = new ItemDao();
		Item itens = itensDao.buscar(codigo);

		if (itens == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			itensDao.excluir(itens);
			System.out.println("Registro encontrado");
			System.out.println(itens.getQtd());
		}
	}
@Test
@Ignore
public void editar() {
	Long codigo = 6L;
	ItemDao itensDao = new ItemDao();
	Item itens = itensDao.buscar(codigo);

	if (itens == null) {
		System.out.println("Nenhum registro encontrado");

	} else {
		itens.setQtd(10);
		itensDao.editar(itens);
		System.out.println("Registro encontrado");
		System.out.println(itens.getQtd());
	}
	
}
}