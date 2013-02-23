package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.TemporadaDao;
import br.com.pcsocial.servidor.daoImp.TemporadaDaoImp;
import br.com.pcsocial.servidor.modelo.Temporada;
import br.com.pcsocial.servidor.servico.TemporadaServ;

public class TemporadaServImp extends UnicastRemoteObject implements TemporadaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaTemporadas;
	private TemporadaDao temporada;

	public TemporadaServImp() throws RemoteException {
		super();
		temporada = new TemporadaDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarTemporadas() throws RemoteException {
		List<Temporada> lista = temporada.list();
		listaTemporadas = new ArrayList(lista);
		return listaTemporadas;
	}

	@Override
	public boolean excluirTemporada(Long id) throws RemoteException {
		temporada.remove(temporada.getTemporada(id));
		 return true;
	}

	@Override
	public boolean adicionarTemporada(Temporada tp) throws RemoteException {
		try {
			temporada.save(tp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarTemporada(Temporada tp) throws RemoteException {
		try {
			temporada.update(tp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Temporada getTemporada(Long id) throws RemoteException {
		return temporada.getTemporada(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarTemporadas(String text, long valor)
			throws RemoteException {
		List<Temporada> lista = temporada.list(text,valor);
		listaTemporadas = new ArrayList(lista);
		return listaTemporadas;
	}

}
