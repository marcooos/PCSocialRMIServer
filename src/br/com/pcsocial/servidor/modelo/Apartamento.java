package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.towel.el.annotation.Resolvable;


@Entity
@Table(name = "apartamento")
public class Apartamento implements Serializable {
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
	@Resolvable(colName = "Abreviação")
	private String descricaoAbreviada;
	@Resolvable(colName = "Venda on-line")
	private char online;
	@Resolvable(colName = "Cod. Tipo PMS")
	private long codTipoPms;
	@Resolvable(colName = "Quantidade do Pool")
	private long quantidadePool;
	@Resolvable(colName = "Quantidade fora do Pool")
	private long quantidadeOutPool;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private List<Empresa> empresa;  

	
	public Apartamento(){
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
	}

	public void setCodTipoPms(long codTipoPms) {
		this.codTipoPms = codTipoPms;
	}

	public long getCodTipoPms() {
		return codTipoPms;
	}
	
	public String getCodTipoPmsStr() {
		return String.valueOf(codTipoPms);
	}
	
	public String getQtdePoolStr() {
		return String.valueOf(quantidadePool);
	}
	
	public String getQtdeOutPoolStr() {
		return String.valueOf(quantidadeOutPool);
	}

	public void setOnline(char online) {
		this.online = online;
	}

	public char getOnline() {
		return online;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setQuantidadePool(long quantidadePool) {
		this.quantidadePool = quantidadePool;
	}

	public long getQuantidadePool() {
		return quantidadePool;
	}

	public void setQuantidadeOutPool(long quantidadeOutPool) {
		this.quantidadeOutPool = quantidadeOutPool;
	}

	public long getQuantidadeOutPool() {
		return quantidadeOutPool;
	}

}
