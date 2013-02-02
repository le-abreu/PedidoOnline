package br.com.empresa.bean.convert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.dao.FornecedorDAO;

public class FornecedorConvert implements Converter{

	//Teste de commit
	public final static String CONVERTER_ID = "br.com.empresa.Fornecedor"; //path dos beans da classe Artista

	@Override
	public Fornecedor getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome_fantasia", valor);
		return new FornecedorDAO().buscaPorParametro(parametros);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Fornecedor) object).getNomeFantasia();
	}

}
