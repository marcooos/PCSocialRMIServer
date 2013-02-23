package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.RestricoesDao;
import br.com.pcsocial.servidor.daoImp.RestricoesDaoImp;
import br.com.pcsocial.servidor.modelo.Restricoes;
import br.com.pcsocial.servidor.servico.RestricoesServ;

public class RestricoesServImp extends UnicastRemoteObject implements RestricoesServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaRestricoess;
	private RestricoesDao restricoes;

	public RestricoesServImp() throws RemoteException {
		super();
		restricoes = new RestricoesDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarRestricoes() throws RemoteException {
		List<Restricoes> lista = restricoes.list();
		listaRestricoess = new ArrayList(lista);
		return listaRestricoess;
	}

	@Override
	public boolean excluirRestricoes(Long id) throws RemoteException {
		restricoes.remove(restricoes.getRestricoes(id));
		 return true;
	}

	@Override
	public boolean adicionarRestricoes(Restricoes rs) throws RemoteException {
		try {
			restricoes.save(rs);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarRestricoes(Restricoes rs) throws RemoteException {
		try {
			restricoes.update(rs);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Restricoes getRestricoes(long id) throws RemoteException {
		return restricoes.getRestricoes(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarRestricoes(String text, long valor)
			throws RemoteException {
		List<Restricoes> lista = restricoes.list(text,valor);
		listaRestricoess = new ArrayList(lista);
		return listaRestricoess;
	}

}
