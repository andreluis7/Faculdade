package br.com.quintatarde.Util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.quintanoite.util.HibernateUtil;



public class HibernateUtilTest {
	@Test
	public  void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		}
	
	

}
