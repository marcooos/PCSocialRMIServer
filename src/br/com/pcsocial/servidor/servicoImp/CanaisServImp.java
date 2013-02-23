package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.CanaisDao;
import br.com.pcsocial.servidor.daoImp.CanaisDaoImp;
import br.com.pcsocial.servidor.modelo.Canais;
import br.com.pcsocial.servidor.servico.CanaisServ;

public class CanaisServImp extends UnicastRemoteObject implements CanaisServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaCanaiss;
	private CanaisDao canais;

	public CanaisServImp() throws RemoteException {
		super();
		canais = new CanaisDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarCanais() throws RemoteException {
		List<Canais> lista = canais.list();
		listaCanaiss = new ArrayList(lista);
		return listaCanaiss;
	}

	@Override
	public boolean excluirCanais(Long id) throws RemoteException {
		canais.remove(canais.getCanais(id));
		 return true;
	}

	@Override
	public boolean adicionarCanais(Canais cn) throws RemoteException {
		try {
			canais.save(cn);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarCanais(Canais cn) throws RemoteException {
		try {
			canais.update(cn);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Canais getCanais(long id) throws RemoteException {
		return canais.getCanais(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarCanais(String text, long valor) throws RemoteException {
		List<Canais> lista = canais.list(text,valor);
		listaCanaiss = new ArrayList(lista);
		return listaCanaiss;
	}

}
