package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.ReceitaDao;
import br.com.pcsocial.servidor.daoImp.ReceitaDaoImp;
import br.com.pcsocial.servidor.modelo.Receita;
import br.com.pcsocial.servidor.servico.ReceitaServ;

public class ReceitaServImp extends UnicastRemoteObject implements ReceitaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaReceitas;
	private ReceitaDao receita;

	public ReceitaServImp() throws RemoteException {
		super();
		receita = new ReceitaDaoImp();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarReceitas() throws RemoteException {
		List<Receita> lista = receita.list();
		listaReceitas = new ArrayList(lista);
		return listaReceitas;
	}

	@Override
	public boolean excluirReceita(Long id) throws RemoteException {
		receita.remove(receita.getReceita(id));
		return true;
	}

	@Override
	public boolean adicionarReceita(Receita rc) throws RemoteException {
		try {
			receita.save(rc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarReceita(Receita rc) throws RemoteException {
		try {
			receita.update(rc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Receita getReceita(Long id) throws RemoteException {
		return receita.getReceita(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarReceitas(String text, long valor)
			throws RemoteException {
		List<Receita> lista = receita.list(text,valor);
		listaReceitas = new ArrayList(lista);
		return listaReceitas;
	}

}
