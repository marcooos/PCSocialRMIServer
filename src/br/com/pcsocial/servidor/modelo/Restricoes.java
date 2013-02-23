package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "restricoes")
public class Restricoes implements Serializable {

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
	@ManyToMany(mappedBy="restricoes",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private List<Tarifa> tarifa;

	public Restricoes() {

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

	public void setTarifa(List<Tarifa> tarifa) {
		this.tarifa = tarifa;
	}

	public List<Tarifa> getTarifa() {
		return tarifa;
	}

}
