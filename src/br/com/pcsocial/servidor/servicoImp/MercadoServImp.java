package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.MercadoDao;
import br.com.pcsocial.servidor.daoImp.MercadoDaoImp;
import br.com.pcsocial.servidor.modelo.Mercado;
import br.com.pcsocial.servidor.servico.MercadoServ;

public class MercadoServImp extends UnicastRemoteObject implements MercadoServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaMercados;
	private MercadoDao mercado;

	public MercadoServImp() throws RemoteException {
		super();
		mercado = new MercadoDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarMercados() throws RemoteException {
		List<Mercado> lista = mercado.list();
		listaMercados = new ArrayList(lista);
		return listaMercados;
	}

	@Override
	public boolean excluirMercado(Long id) throws RemoteException {
		mercado.remove(mercado.getMercado(id));
		 return true;
	}

	@Override
	public boolean adicionarMercado(Mercado mc) throws RemoteException {
		try {
			mercado.save(mc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarMercado(Mercado mc) throws RemoteException {
		try {
			mercado.update(mc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Mercado getMercado(long id) throws RemoteException {
		return mercado.getMercado(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarMercados(String text, long valor)
			throws RemoteException {
		List<Mercado> lista = mercado.list(text,valor);
		listaMercados = new ArrayList(lista);
		return listaMercados;
	}

}
