package br.com.empresa.bean.convert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.empresa.bean.Produto;
import br.com.empresa.dao.ProdutoDAO;

public class ProdutoConvert implements Converter{

	//Teste de commit
	public final static String CONVERTER_ID = "br.com.desenrola.bean.Artista"; //path dos beans da classe Artista

	@Override
	public Produto getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome", valor);
		return new ProdutoDAO().buscaPorParametro(parametros);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Produto) object).getNome();
	}

}
