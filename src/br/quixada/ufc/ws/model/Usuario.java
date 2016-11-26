package br.quixada.ufc.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "senha")
	private String senha;

	
	//GETs & SETs
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
