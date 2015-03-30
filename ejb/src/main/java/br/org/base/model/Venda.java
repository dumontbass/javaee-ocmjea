package br.org.base.model;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

//@Entity
@NamedNativeQueries( { 
	@NamedNativeQuery(name = "Venda.find", query = 
		"select p.nome as nome_pessoa, pr.nome as nome_produto , pr.valor as valor "
		+ "from venda as v "
		+ "inner join pessoa as p on v.pessoa = p.id "
		+ "inner join produto as pr on v.produto = pr.id; "
		, resultSetMapping="GetVenda"
	)
})

@SqlResultSetMapping(name = "GetVenda", entities={
		@EntityResult(entityClass=Venda.class,fields={
				@FieldResult(name="nome", column="nome_produto"),
				@FieldResult(name="pessoa", column="nome_pessoa"),
				@FieldResult(name="valor", column="valor")
		})
		}
)

public class Venda {
	

	
	private String nome;
	private String pessoa;
	private Float valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	

}
