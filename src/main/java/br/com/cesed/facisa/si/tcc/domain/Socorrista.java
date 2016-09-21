package br.com.cesed.facisa.si.tcc.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Socorrista")
public class Socorrista implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	private String id;
	private String nome;
	private int telefone;
	private String email;
	private String capacitacao;
	
	public Socorrista () {
	}
	
	public Socorrista (String id, String nome, int telefone, String email, String capacitacao) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.capacitacao = capacitacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getCapacitacao() {
		return capacitacao;
	}

	public void setCapacitacao(String capacitacao) {
		this.capacitacao = capacitacao;
	}
	
	@Override
	public String toString() {
		return "Socorrista [id= " + id + ", nome= " + nome + ", telefone= " + telefone + ", email= " + email + ", capacitacao= " + capacitacao + "]";
	}

}