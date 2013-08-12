package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "temporada")
public class Temporada implements Serializable {

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
	@Resolvable(colName = "Data Inical")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataInicial;
	@Resolvable(colName = "Data Final")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataFinal;
	@Resolvable(colName = "Venda ativa")
	private char vendaAtiva;

	public Temporada() {

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

	public void setDataInicial(Date dataIninical) {
		this.dataInicial = dataIninical;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setVendaAtiva(char vendaAtiva) {
		this.vendaAtiva = vendaAtiva;
	}

	public char getVendaAtiva() {
		return vendaAtiva;
	}

}
