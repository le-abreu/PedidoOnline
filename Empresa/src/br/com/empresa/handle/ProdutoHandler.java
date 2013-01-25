package br.com.empresa.handle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.empresa.bean.Produto;
import br.com.empresa.dao.ProdutoDAO;
import br.com.empresa.util.ControllerArquivo;

public class ProdutoHandler {

	public String pesquisaProduto;
	private Produto produto = new Produto();
	private Produto produtoEscolhido;
	private List<Produto> produtos;
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private final static String path = "C:\\Users\\LeulSeixas\\Desktop\\Fiap\\Project\\PedidoOnline\\Empresa\\WebContent";
	private StreamedContent imagem;


	public String getPesquisaProduto() {
		return pesquisaProduto;
	}

	public void setPesquisaProduto(String pesquisaProduto) {
		this.pesquisaProduto = pesquisaProduto;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoEscolhido() {
		return produtoEscolhido;
	}

	public void setProdutoEscolhido(Produto produtoEscolhido) {
		this.produtoEscolhido = produtoEscolhido;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void uploadFoto(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Sucesso!!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			imagem = new DefaultStreamedContent(event.getFile()
					.getInputstream(), "image/jpeg", event.getFile()
					.getFileName());

			ControllerArquivo.guardarArquivo(imagem.getStream(), path
					+ "\\imagens\\temp\\produto\\", "fotoPerfil.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String salvar() {

		boolean isDeletar = true;
		produtoDAO.update(produto);
		int id = produto.getId() != 0 ? produto.getId() : produtoDAO.lista()
				.size() == 0 ? 1 : produtoDAO.lista().size();

		try {
			File file = new File(path
					+ "\\imagens\\temp\\produto\\fotoPerfil.jpg");
			if (!file.exists()) {
				isDeletar = false;
				file = new File(path
						+ "\\imagens\\temp\\produto\\fotoPerfilPadrao.jpg");
			}
			ControllerArquivo.guardarArquivo(new FileInputStream(file), path
					+ "\\imagens\\produto\\", id + ".jpg");
			produto = new Produto();
			if (isDeletar)
				file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Salvar";
	}

	public List<Produto> getListaProduto() {
		produtos = produtoDAO.lista();
		return produtos;
	}

	public void selecionaArtista(ActionEvent event) {
		File file;
		file = new File(path + "\\imagens\\produto\\fotoPerfil.jpg");
		file.delete();

		UIParameter val = (UIParameter) event.getComponent().findComponent(
				"idArtista");
		int id = Integer.parseInt(val.getValue().toString());
		produto = produtoDAO.find(id);

		file = new File(path + "\\imagens\\produto\\" + produto.getId()
				+ ".jpg");
		try {
			ControllerArquivo.guardarArquivo(new FileInputStream(file), path
					+ "\\imagens\\temp\\produto\\", "fotoPerfil.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteArtista(ActionEvent event) {
		File file;

		UIParameter val = (UIParameter) event.getComponent().findComponent(
				"idProdutoDel");
		int id = Integer.parseInt(val.getValue().toString());
		produto = produtoDAO.find(id);

		file = new File(path + "\\imagens\\produto\\" + produto.getId()
				+ ".jpg");
		file.delete();
		produtoDAO.delete(produto);
	}
	
	public void pesquisaListProduto() {

	}
}