package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Resolvable(colName = "Descrição")
	private String descricao;

	public Pais() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String Descricao) {
		this.descricao = Descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
