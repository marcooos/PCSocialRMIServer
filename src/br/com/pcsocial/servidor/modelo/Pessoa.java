package br.com.pcsocial.servidor.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.towel.el.annotation.Resolvable;

/**
 * 
 * @author marcos
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Resolvable(colName = "Id")
	private long id;
	@Column(nullable = false)
	@Resolvable(colName = "E-mail")
	private String email;
	@Column(nullable = false)
	@Resolvable(colName = "Senha")
	private String senha;
	@Resolvable(colName = "Nome/Razão Social")
	private String nomeRazaoSocial;
	@Resolvable(colName = "Sobrenome/Nome Fantasia")
	private String sobreNomeFantasia;
	@Resolvable(colName = "CPF/CNPJ")
	private String cpfCnpj;
	@Resolvable(colName = "Logradouro")
	private String endereco;
	@Resolvable(colName = "Numero")
	private String enderecoNumero;
	@Resolvable(colName = "Complemento")
	private String enderecoComplemento;
	@Resolvable(colName = "Bairro")
	private String bairro;
	@Resolvable(colName = "CEP")
	private String cep;
	@OneToOne
    private Cidade cidadeRef;
	@Resolvable(colName = "Atribuiçã")
	private char atribuicao; //C - Cliente, H - H�spede. U - Usu�rio, O - Operadora
	@OneToOne
	private Mercado segMercado;

	public Pessoa() {
		segMercado = new Mercado();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		
		this.cep = cep;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getSobreNomeFantasia() {
		return sobreNomeFantasia;
	}

	public void setSobreNomeFantasia(String sobreNomeFantasia) {
		this.sobreNomeFantasia = sobreNomeFantasia;
	}

	public void setAtribuicao(char atribuicao) {
		this.atribuicao = atribuicao;
	}

	public char getAtribuicao() {
		return atribuicao;
	}

	public void setCidadeRef(Cidade cidadeRef) {
		this.cidadeRef = cidadeRef;
	}

	public Cidade getCidadeRef() {
		return cidadeRef;
	}

	public void setSegMercado(Mercado segMercado) {
		this.segMercado = segMercado;
	}

	public Mercado getSegMercado() {
		return segMercado;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

}
