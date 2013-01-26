package br.com.empresa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)  
private Long id;	
	
private String rua;


private String lougradouro;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


private String numero;


private String complemento;


public String getRua() {
	return rua;
}


public void setRua(String rua) {
	this.rua = rua;
}


public String getLougradouro() {
	return lougradouro;
}


public void setLougradouro(String lougradouro) {
	this.lougradouro = lougradouro;
}


public String getNumero() {
	return numero;
}


public void setNumero(String numero) {
	this.numero = numero;
}


public String getComplemento() {
	return complemento;
}


public void setComplemento(String complemento) {
	this.complemento = complemento;
}


}
