package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.EmpresaDao;
import br.com.pcsocial.servidor.daoImp.EmpresaDaoImp;
import br.com.pcsocial.servidor.modelo.Empresa;
import br.com.pcsocial.servidor.servico.EmpresaServ;

public class EmpresaServImp extends UnicastRemoteObject implements EmpresaServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaEmpresas;
	private EmpresaDao empresa;

	public EmpresaServImp() throws RemoteException {
		super();
		empresa = new EmpresaDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarEmpresas() throws RemoteException {
		List<Empresa> lista = empresa.list();
		listaEmpresas = new ArrayList(lista);
		return listaEmpresas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarEmpresas(Long id) throws RemoteException {
		List<Empresa> lista = empresa.list(id);
		listaEmpresas = new ArrayList(lista);
		return listaEmpresas;
	}

	@Override
	public boolean excluirEmpresa(Long id) throws RemoteException {
		empresa.remove(empresa.getEmpresa(id));
		return true;
	}

	@Override
	public boolean adicionarEmpresa(Empresa em) throws RemoteException {
		try {
			empresa.save(em);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarEmpresa(Empresa em) throws RemoteException {
		try {
			empresa.update(em);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarEmpresas(String text, long valor)
			throws RemoteException {
		List<Empresa> lista = empresa.list(text,valor);
		listaEmpresas = new ArrayList(lista);
		return listaEmpresas;
	}

}
