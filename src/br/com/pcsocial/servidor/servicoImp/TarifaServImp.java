package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.TarifaDao;
import br.com.pcsocial.servidor.daoImp.TarifaDaoImp;
import br.com.pcsocial.servidor.modelo.Tarifa;
import br.com.pcsocial.servidor.servico.TarifaServ;

public class TarifaServImp extends UnicastRemoteObject implements TarifaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaTarifas;
	private TarifaDao tarifa;

	public TarifaServImp() throws RemoteException {
		super();
		tarifa = new TarifaDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarTarifa() throws RemoteException {
		List<Tarifa> lista = tarifa.list();
		listaTarifas = new ArrayList(lista);
		return listaTarifas;
	}

	@Override
	public boolean excluirTarifa(Long id) throws RemoteException {
		tarifa.remove(tarifa.getTarifa(id));
		 return true;
	}

	@Override
	public boolean adicionarTarifa(Tarifa tr) throws RemoteException {
		try {
			tarifa.save(tr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarTarifa(Tarifa tr) throws RemoteException {
		try {
			tarifa.update(tr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Tarifa getTarifa(long id) throws RemoteException {
		return tarifa.getTarifa(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarTarifa(String text, long valor) throws RemoteException {
		List<Tarifa> lista = tarifa.list(text,valor);
		listaTarifas = new ArrayList(lista);
		return listaTarifas;
	}

}
