package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.ClassesDao;
import br.com.pcsocial.servidor.daoImp.ClassesDaoImp;
import br.com.pcsocial.servidor.modelo.Classes;
import br.com.pcsocial.servidor.servico.ClassesServ;

public class ClassesServImp extends UnicastRemoteObject implements ClassesServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaClassess;
	private ClassesDao classes;

	public ClassesServImp() throws RemoteException {
		super();
		classes = new ClassesDaoImp();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarClasses() throws RemoteException {
		List<Classes> lista = classes.list();
		listaClassess = new ArrayList(lista);
		return listaClassess;
	}

	@Override
	public boolean excluirClasses(Long id) throws RemoteException {
		classes.remove(classes.getClasses(id));
		return true;
	}

	@Override
	public boolean adicionarClasses(Classes cl) throws RemoteException {
		try {
			classes.save(cl);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarClasses(Classes cl) throws RemoteException {
		try {
			classes.update(cl);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Classes getClasses(long id) throws RemoteException {
		return classes.getClasses(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarClasses(String text, long valor)
			throws RemoteException {
		List<Classes> lista = classes.list(text,valor);
		listaClassess = new ArrayList(lista);
		return listaClassess;
	}

}
