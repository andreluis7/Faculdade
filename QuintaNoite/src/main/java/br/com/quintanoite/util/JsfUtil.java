package br.com.quintanoite.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JsfUtil {
	
//	String para busca de parametros atraves de mapeamento
	public static String getParam(String nome) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		ExternalContext external = contexto.getExternalContext();
		
		Map<String, String> parametros = external.getRequestParameterMap();
		
		String valor = parametros.get(nome);
		
		return valor;
	}

}
