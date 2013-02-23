package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.PaisDao;
import br.com.pcsocial.servidor.daoImp.PaisDaoImp;
import br.com.pcsocial.servidor.modelo.Pais;
import br.com.pcsocial.servidor.servico.PaisServ;

public class PaisServImp extends UnicastRemoteObject implements PaisServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaPaises;
	private PaisDao pais;

	public PaisServImp() throws RemoteException {
		super();
		pais = new PaisDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarPaises() throws RemoteException {
		List<Pais> lista = pais.list();
		listaPaises = new ArrayList(lista);
		return listaPaises;
	}

	@Override
	public boolean excluirPais(Long id) throws RemoteException {
		pais.remove(pais.getPais(id));
		 return true;
	}

	@Override
	public boolean adicionarPais(Pais ps) throws RemoteException {
		try {
			pais.save(ps);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarPais(Pais ps) throws RemoteException {
		try {
			pais.update(ps);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
