package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "detHospedagem")
public class DetHospedagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private long diasHospedado;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataEntrada;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataSaida;
	@ManyToOne(cascade = CascadeType.PERSIST, optional=true)
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Hospedagem hospedagem;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Tarifa tarifa;

	public DetHospedagem() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
