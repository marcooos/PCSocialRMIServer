package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "classes")
public class Classes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Resolvable(colName = "Id")
	private long id;
	@Resolvable(colName = "Descri��o")
	private String descricao;	

	public Classes() {

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

}
