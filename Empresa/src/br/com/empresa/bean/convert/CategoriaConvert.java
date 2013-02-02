package br.com.empresa.bean.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.empresa.bean.Categoria;
import br.com.empresa.dao.CategoriaDAO;

public class CategoriaConvert implements Converter{

	//Teste de commit
	public final static String CONVERTER_ID = "br.com.empresa.bean.Categoria"; //path dos beans da classe Categoria

	@Override
	public Categoria getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		return new CategoriaDAO().buscaPorParametro(null, valor);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Categoria) object).getNome();
	}

}
