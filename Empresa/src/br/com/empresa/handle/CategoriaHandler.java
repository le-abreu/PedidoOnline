package br.com.empresa.handle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.empresa.bean.Categoria;
import br.com.empresa.dao.CategoriaDAO;
import br.com.empresa.util.ControllerArquivo;

@ManagedBean(name = "categoriaHandle")
@RequestScoped
public class CategoriaHandler {

	public String pesquisaCategoria;
	private Categoria categoria = new Categoria();
	private List<Categoria> categorias;
	private CategoriaDAO categoriaDAO = new CategoriaDAO();
	private StreamedContent imagem;
	
	{
		categorias = categoriaDAO.lista();
	}
	
	public String getPesquisaCategoria() {
		return pesquisaCategoria;
	}

	public void setPesquisaCategoria(String pesquisaCategoria) {
		this.pesquisaCategoria = pesquisaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria Categoria) {
		this.categoria = Categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> Categorias) {
		this.categorias = Categorias;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	
	
	public String salvar() {
		boolean isDeletar = true;
		
		try {
			categoriaDAO.update(categoria);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		int id = categoria.getId() != 0 ? categoria.getId() : categoriaDAO.lista().size() == 0 ? 1 : categoriaDAO.lista().size();

		try {
			File file = new File(ControllerArquivo.criarArquivo("imagens\\temp\\categoria\\fotoPerfil.jpg"));
			if (!file.exists()) {
				isDeletar = false;
				file = new File(ControllerArquivo.criarArquivo("imagens\\temp\\categoria\\fotoPerfilPadrao.jpg"));
			}
			ControllerArquivo.guardarArquivo(new FileInputStream(file), "imagens\\categoria\\", id + ".jpg");
			if (isDeletar)
				file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		categoria = new Categoria();
		return "Salvar";
	}

	public List<Categoria> getListaCategoria() {
		categorias = categoriaDAO.lista();
		return categorias;
	}

	public String pesquisaListCategoria(ActionEvent event) {
		if(pesquisaCategoria.isEmpty())
			categorias = categoriaDAO.lista();
		else
			categorias = categoriaDAO.buscaListaPorParametro(null, pesquisaCategoria);
		return "Salvar";
	}
	
	
	public void uploadFoto(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			imagem = new DefaultStreamedContent(event.getFile().getInputstream(), "image/jpeg", event.getFile().getFileName());
			ControllerArquivo.guardarArquivo(imagem.getStream(), "imagens\\temp\\categoria\\", "fotoPerfil.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void selecionaCategoria(ActionEvent event) {
		File file;
		file = new File(ControllerArquivo.criarArquivo("imagens\\categoria\\fotoPerfil.jpg"));
		file.delete();

		UIParameter val = (UIParameter) event.getComponent().findComponent("idCategoria");
		int id = Integer.parseInt(val.getValue().toString());
		categoria = categoriaDAO.find(id);

		file = new File(ControllerArquivo.criarArquivo("imagens\\categoria\\" + categoria.getId()	+ ".jpg"));
		try {
			ControllerArquivo.guardarArquivo(new FileInputStream(file), "imagens\\temp\\categoria\\", "fotoPerfil.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void novaCategoria(ActionEvent event) {
		this.categoria =  new Categoria();
	}
	
	
}