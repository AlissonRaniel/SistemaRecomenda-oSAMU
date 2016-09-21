package br.com.cesed.facisa.si.tcc.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Chamado")
public class Chamado implements Serializable{
		

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String data;
	private String hora;
	private String queixa;	
//	private List<Socorrista> socorristas;

	
	public Chamado() {
	}
	
	
	public Chamado(String id, String data, String hora, String queixa) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.queixa = queixa;
//		this.socorristas = new LinkedList<Socorrista>();
	}
	public Chamado(String id, String data, String hora, String queixa, List<Socorrista> socorristas) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.queixa = queixa;
//		this.socorristas = socorristas;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getQueixa() {
		return queixa;
	}


	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}


//	public List<Socorrista> getSocorristas() {
//		return socorristas;
//	}
//
//
//	public void setSocorristas(List<Socorrista> socorristas) {
//		this.socorristas = socorristas;
//	}


//	@Override
//	public String toString() {
//		return "Chamado [id=" + id + ", data=" + data + ", hora=" + hora + ", queixa=" + queixa + ", socorristas="
//				+ socorristas + "]";
//	}
	
	
}

