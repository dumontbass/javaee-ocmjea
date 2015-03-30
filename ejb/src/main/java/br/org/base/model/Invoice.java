package br.org.base.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Invoice.find", query = "select i from Invoice i where i.id = :id"),
	@NamedQuery(name = "Invoice.findAll", query = "select m from Invoice m ")
})
public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 6157518782991223183L;
	
	@Id
    @GeneratedValue
    private Long id;
	
	private Long orderNumber;
	private Float value;
	private Periodicity periodicity;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public Periodicity getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
	
	
}
