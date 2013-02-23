package br.com.pcsocial.servidor.modelo;

/**
 *
 * @author marcos
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Resolvable(colName = "Descrição")
	private String descricao;
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.JOIN)
	private Pais pais;

	public Estado() {
		pais = new Pais();
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getDescricaoPesquisa() {
		return ", " + descricao + ", ";
	}
}
