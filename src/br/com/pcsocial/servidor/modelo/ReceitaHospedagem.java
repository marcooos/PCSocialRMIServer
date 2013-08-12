package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "recHospedagem")
public class ReceitaHospedagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "valor", precision = 2, length = 15)
	private Double valor;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataReceita;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Hospedagem hospedagem;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Receita receita;

	public ReceitaHospedagem() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Date dataReceita) {
		this.dataReceita = dataReceita;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
