package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "tarifa")
public class Tarifa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Resolvable(colName = "Id")
	private long id;
	@Resolvable(colName = "Descrição")
	private String descricao;
	@Resolvable(colName = "Cod. Tarifa PMS")
	private long codPms;
	@Resolvable(colName = "Venda on-line")
	private char vendaOnline;
	@Resolvable(colName = "Venda variavél")
	private char tarifaVariavel;
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private List<Restricoes> restricoes;
	@OneToOne
	private Classes classes;
	

	public Tarifa() {

	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCodPms(long codPms) {
		this.codPms = codPms;
	}

	public long getCodPms() {
		return codPms;
	}
	
	public String getCodPmsStr() {
		return String.valueOf(codPms);
	}

	public void setVendaOnline(char vendaOnline) {
		this.vendaOnline = vendaOnline;
	}

	public char getVendaOnline() {
		return vendaOnline;
	}

	public void setTarifaVarial(char tarifaVariavel) {
		this.tarifaVariavel = tarifaVariavel;
	}

	public char getTarifaVarial() {
		return tarifaVariavel;
	}

	public void setRestricoes(List<Restricoes> restricoes) {
		this.restricoes = restricoes;
	}

	public List<Restricoes> getRestricoes() {
		return restricoes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Classes getClasses() {
		return classes;
	}
}
