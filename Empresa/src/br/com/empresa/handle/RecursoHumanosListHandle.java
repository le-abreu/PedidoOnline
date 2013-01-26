package br.com.empresa.handle;

import java.io.File;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.primefaces.event.CaptureEvent;

import br.com.empresa.bean.Endereco;
import br.com.empresa.bean.Funcionario;
import br.com.empresa.dao.FuncionarioDao;

@ManagedBean(name = "rh_list")
@SessionScoped
public class RecursoHumanosListHandle {

	public String pesquisa;

	private Funcionario novoFuncionario = new Funcionario();

	private Boolean inserirFuncionario = false;

	private String status;

	private List<Funcionario> listaFuncionario = new ArrayList<>();

	private Funcionario funcionarioSelecionado = new Funcionario();

	private String imagem;

	private Boolean imagemTirada = false;

	public Boolean getImagemTirada() {
		return imagemTirada;
	}

	public void setImagemTirada(Boolean imagemTirada) {
		this.imagemTirada = imagemTirada;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	private Endereco endereco = new Endereco();

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void listaFuncionarios() {

		FuncionarioDao dao = new FuncionarioDao();
		listaFuncionario = dao.lista();

	}

	public void exportaExcel() {

	}

	public void exportaPdf() {

	}

	public void editar() throws SQLException {

		inserirFuncionario = false;		
		
		try {
			byte[] data = novoFuncionario.getPhotos().getBytes(1,(int) novoFuncionario.getPhotos().length() );
		
		
			this.photos.add(0, "img001");
			
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			String newFileName = servletContext.getRealPath("") + File.separator
					+ "content" + File.separator + "images" + File.separator
					+ "img001" + ".png";
			FileImageOutputStream imageOutput;
			try {
				imageOutput = new FileImageOutputStream(new File(newFileName));
				imageOutput.write(data, 0, data.length);
				imageOutput.close();
				
				Blob blob = new SerialBlob(data);
				novoFuncionario.setPhotos(blob);
				
				imagem = newFileName;
			} catch (Exception e) {
				throw new FacesException("Error in writing captured image.");
			}
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return;
	
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Funcionario getNovoFuncionario() {
		return novoFuncionario;
	}

	public void setNovoFuncionario(Funcionario novoFuncionario) {
		this.novoFuncionario = novoFuncionario;
	}

	public Boolean getInserirFuncionario() {
		return inserirFuncionario;
	}

	public void setInserirFuncionario(Boolean inserirFuncionario) {
		this.inserirFuncionario = inserirFuncionario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public void inserirNovoFunc() {
		FuncionarioDao dao = new FuncionarioDao();
		try {
			dao.persist(novoFuncionario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void btnVer() {
		
		try {
			byte[] data = novoFuncionario.getPhotos().getBytes(1,(int) novoFuncionario.getPhotos().length() );
		
		
			this.photos.add(0, "img001");
			
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			String newFileName = servletContext.getRealPath("") + File.separator
					+ "content" + File.separator + "images" + File.separator
					+ "img001" + ".png";
			FileImageOutputStream imageOutput;
			try {
				imageOutput = new FileImageOutputStream(new File(newFileName));
				imageOutput.write(data, 0, data.length);
				imageOutput.close();
				
				Blob blob = new SerialBlob(data);
				novoFuncionario.setPhotos(blob);
				
				imagem = newFileName;
			} catch (Exception e) {
				throw new FacesException("Error in writing captured image.");
			}
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		inserirFuncionario = true;
		
	}

	public void btnNovo() {

		imagemTirada = false;

	}

	public void btnTiraFoto() {

		imagemTirada = true;

	}

	public void oncapture(CaptureEvent captureEvent) {

		byte[] data = captureEvent.getData();

		this.photos.add(0, "img001");
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String newFileName = servletContext.getRealPath("") + File.separator
				+ "content" + File.separator + "images" + File.separator
				+ "img001" + ".png";
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();

			Blob blob = new SerialBlob(data);
			novoFuncionario.setPhotos(blob);

			imagem = newFileName;
			imagemTirada = true;
		} catch (Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	private List<String> photos = new ArrayList<String>();

}
