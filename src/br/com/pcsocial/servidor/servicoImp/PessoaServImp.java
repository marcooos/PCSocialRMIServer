package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.PessoaDao;
import br.com.pcsocial.servidor.daoImp.PessoaDaoImp;
import br.com.pcsocial.servidor.modelo.Pessoa;
import br.com.pcsocial.servidor.servico.PessoaServ;

public class PessoaServImp extends UnicastRemoteObject implements PessoaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaPessoas;
	private PessoaDao pessoa;

	public PessoaServImp() throws RemoteException {
		super();
		pessoa = new PessoaDaoImp();

	}

	public boolean validarLogin(String email, String senha)
			throws RemoteException {
		return pessoa.validarLogin(email, senha);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getListarPessoas() {
		List<Pessoa> lista = pessoa.list();
		listaPessoas = new ArrayList(lista);
		return listaPessoas;
	}
	
	public boolean adicionarPessoa(Pessoa p) {
		try {
			pessoa.save(p);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean alterarPessoa(Pessoa p) {
		try {
			pessoa.update(p);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarPessoas(Long id) throws RemoteException {
		List<Pessoa> lista = pessoa.list(id);
		listaPessoas = new ArrayList(lista);
		return listaPessoas;
	}

	@Override
	public boolean excluirPessoa(Long id) throws RemoteException {
		pessoa.remove(pessoa.getPessoa(id));
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarPessoas(String text, long valor) throws RemoteException {
		List<Pessoa> lista = pessoa.list(text,valor);
		listaPessoas = new ArrayList(lista);
		return listaPessoas;
	}

}
