package br.org.base.mock;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.org.base.test.Sexo;

@Entity
public class Pessoa {
	
	public Pessoa() {
		super();
	}


	@Id
	private Long id;
	private String nome;
	private int idade;
	private Sexo sexo;
	
	
	public Pessoa(String nome, int idade, Sexo sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	

	






}
