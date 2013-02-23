package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.DemandaDao;
import br.com.pcsocial.servidor.daoImp.DemandaDaoImp;
import br.com.pcsocial.servidor.modelo.Demanda;
import br.com.pcsocial.servidor.servico.DemandaServ;

public class DemandaServImp extends UnicastRemoteObject implements DemandaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaDemandas;
	private DemandaDao demanda;

	public DemandaServImp() throws RemoteException {
		super();
		demanda = new DemandaDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarDemandas() throws RemoteException {
		List<Demanda> lista = demanda.list();
		listaDemandas = new ArrayList(lista);
		return listaDemandas;
	}

	@Override
	public boolean excluirDemanda(Long id) throws RemoteException {
		 demanda.remove(demanda.getDemanda(id));
		 return true;
	}

	@Override
	public boolean adicionarDemanda(Demanda dm) throws RemoteException {
		try {
			demanda.save(dm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarDemanda(Demanda dm) throws RemoteException {
		try {
			demanda.update(dm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Demanda getDemanda(Long id) throws RemoteException {
		return demanda.getDemanda(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarDemandas(String text, long valor)
			throws RemoteException {
		List<Demanda> lista = demanda.list(text,valor);
		listaDemandas = new ArrayList(lista);
		return listaDemandas;
	}

}



