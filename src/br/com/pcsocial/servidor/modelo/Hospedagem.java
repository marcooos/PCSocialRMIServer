package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "hospedagem")
public class Hospedagem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private long codPms;
	private long diasHospedado;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataEntrada;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSaida;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Mercado mercado;

	public Hospedagem() {
		pessoa = new Pessoa();
		mercado = new Mercado();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodPms() {
		return codPms;
	}

	public void setCodPms(long codPms) {
		this.codPms = codPms;
	}

	public long getDiasHospedado() {
		return diasHospedado;
	}

	public void setDiasHospedado(long diasHospedado) {
		this.diasHospedado = diasHospedado;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public Mercado getMercado() {
		return mercado;
	}

}
