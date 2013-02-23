package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.EstadoDao;
import br.com.pcsocial.servidor.daoImp.EstadoDaoImp;
import br.com.pcsocial.servidor.modelo.Estado;
import br.com.pcsocial.servidor.servico.EstadoServ;

public class EstadoServImp  extends UnicastRemoteObject implements EstadoServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaEstados;
	private EstadoDao estado;

	public EstadoServImp() throws RemoteException {
		super();
		estado = new EstadoDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarEstados() throws RemoteException {
		List<Estado> lista = estado.list();
		listaEstados = new ArrayList(lista);
		return listaEstados;
	}

	@Override
	public boolean excluirEstado(Long id) throws RemoteException {
		estado.remove(estado.getEstado(id));
		 return true;
	}

	@Override
	public boolean adicionarEstado(Estado es) throws RemoteException {
		try {
			estado.save(es);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarEstado(Estado es) throws RemoteException {
		try {
			estado.update(es);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}