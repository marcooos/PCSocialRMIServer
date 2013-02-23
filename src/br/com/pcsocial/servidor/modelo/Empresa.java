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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.towel.el.annotation.Resolvable;

/**
 * 
 * @author marcos
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Resolvable(colName = "Id")
	private long id;
	@Resolvable(colName = "Cod. Empresa PMS")
	private long codempresa;
	@Resolvable(colName = "Atribuição da Empresa")
	private char atrEmpresa;
	@OneToOne
	private Pessoa pessoaEmpresa;
	@ManyToMany(mappedBy="empresa",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private List<Apartamento> apartamento;
	
	public Empresa(){
		pessoaEmpresa = new Pessoa();
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setPessoaEmpresa(Pessoa pessoaEmpresa) {
		this.pessoaEmpresa = pessoaEmpresa;
	}

	public Pessoa getPessoaEmpresa() {
		return pessoaEmpresa;
	}

	public void setCodempresa(long codempresa) {
		this.codempresa = codempresa;
	}

	public long getCodempresa() {
		return codempresa;
	}
	
	public String getCodempresaStr() {
		return String.valueOf(codempresa);
	}

	public void setApartamento(List<Apartamento> apartamento) {
		this.apartamento = apartamento;
	}

	public List<Apartamento> getApartamento() {
		return apartamento;
	}

	public void setAtrEmpresa(char atrEmpresa) {
		this.atrEmpresa = atrEmpresa;
	}

	public char getAtrEmpresa() {
		return atrEmpresa;
	}


}
