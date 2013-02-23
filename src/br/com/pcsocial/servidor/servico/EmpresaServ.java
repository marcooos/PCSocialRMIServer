package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Empresa;

public interface EmpresaServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarEmpresas() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarEmpresas(Long id) throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarEmpresas(String text, long valor) throws RemoteException;

	public boolean excluirEmpresa(Long id) throws RemoteException;

	public boolean adicionarEmpresa(Empresa em) throws RemoteException;

	public boolean alterarEmpresa(Empresa em) throws RemoteException;
}
