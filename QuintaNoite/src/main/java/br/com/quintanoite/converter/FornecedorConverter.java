package br.com.quintanoite.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;

@FacesConverter
public class FornecedorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			FornecedorDao dao = new FornecedorDao();
			Fornecedor fornecedor = dao.buscar(codigo);
			return fornecedor;
			
		} catch (RuntimeException ex) {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object objeto) {
		try {
			Fornecedor fornecedor = (Fornecedor)objeto;
			Long codigo = fornecedor.getCodigo();
			return codigo.toString();
			
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
