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
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.empresa.bean.Categoria;
import br.com.empresa.bean.Estoque;
import br.com.empresa.bean.Fornecedor;
import br.com.empresa.bean.Produto;
import br.com.empresa.bean.TipoLancamentoEnum;
import br.com.empresa.dao.CategoriaDAO;
import br.com.empresa.dao.EstoqueDAO;
import br.com.empresa.dao.FornecedorDAO;
import br.com.empresa.dao.ProdutoDAO;
import br.com.empresa.util.ControllerArquivo;

@ManagedBean(name = "produtoHandle")
@RequestScoped
public class ProdutoHandler {

	public String pesquisaProduto;
	private Produto produto = new Produto();
	private Estoque estoque = new Estoque();
	private Produto produtoEscolhido;
	private List<Produto> produtos;
	private EstoqueDAO estoqueDAO = new EstoqueDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private StreamedContent imagem;

	{
		produtos = produtoDAO.lista();
	}
	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

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
			imagem = new DefaultStreamedContent(event.getFile().getInputstream(), "image/jpeg", event.getFile().getFileName());
			ControllerArquivo.guardarArquivo(imagem.getStream(), "\\imagens\\temp\\produto\\", "fotoPerfil.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String salvar() {

		boolean isDeletar = true;
		try {
			produtoDAO.update(produto);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		int id = produto.getId() != 0 ? produto.getId() : produtoDAO.lista()
				.size() == 0 ? 1 : produtoDAO.lista().size();

		try {
			File file = new File(ControllerArquivo.criarArquivo("\\imagens\\temp\\produto\\fotoPerfil.jpg"));
			if (!file.exists()) {
				isDeletar = false;
				file = new File(ControllerArquivo.criarArquivo("\\imagens\\temp\\produto\\fotoPerfilPadrao.jpg"));
			}
			ControllerArquivo.guardarArquivo(new FileInputStream(file), "\\imagens\\produto\\", id + ".jpg");
			produto = new Produto();
			if (isDeletar)
				file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Salvar";
	}
	
	public String salvarEstoque() throws Exception {
		estoque.setProduto(produto);
		estoqueDAO.persist(estoque);
		estoque =  new Estoque();
		produto =  new Produto();
		return "Salvar";
	}

	public List<Produto> getListaProduto() {
		produtos = produtoDAO.lista();
		return produtos;
	}

	public void selecionaProduto(ActionEvent event) {
		File file;
		file = new File(ControllerArquivo.criarArquivo("\\imagens\\produto\\fotoPerfil.jpg"));
		file.delete();

		UIParameter val = (UIParameter) event.getComponent().findComponent("idProduto");
		int id = Integer.parseInt(val.getValue().toString());
		produto = produtoDAO.find(id);

		file = new File(ControllerArquivo.criarArquivo("\\imagens\\produto\\" + produto.getId()	+ ".jpg"));
		try {
			ControllerArquivo.guardarArquivo(new FileInputStream(file), "\\imagens\\temp\\produto\\", "fotoPerfil.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduto(ActionEvent event) {
		File file;

		UIParameter val = (UIParameter) event.getComponent().findComponent("idProdutoDel");
		int id = Integer.parseInt(val.getValue().toString());
		produto = produtoDAO.find(id);

		file = new File(ControllerArquivo.criarArquivo("\\imagens\\produto\\" + produto.getId() + ".jpg"));
		file.delete();
		try {
			produtoDAO.delete(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String pesquisaListProduto(ActionEvent event) {
		if(pesquisaProduto.isEmpty())
			produtos = produtoDAO.lista();
		else
			produtos = produtoDAO.buscaListaPorParametro(pesquisaProduto);

		return "Salvar";
	}
	
	public SelectItem[] getTipoLancamentoEnum() {
		SelectItem[] items = new SelectItem[TipoLancamentoEnum.values().length];
		int i = 0;
		for (TipoLancamentoEnum t : TipoLancamentoEnum.values()) {
			items[i++] = new SelectItem(t, ""+t);
		}
		return items;
	}
	
	public List<Categoria> getCategorias() {
		return new CategoriaDAO().lista();
	}
	
	public List<Fornecedor> getFornecedores() {
		return new FornecedorDAO().lista();
	}
}