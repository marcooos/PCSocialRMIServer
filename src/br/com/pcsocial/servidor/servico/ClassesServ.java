package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Classes;

public interface ClassesServ  extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarClasses() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarClasses(String text, long valor) throws RemoteException;
	
	public Classes getClasses(long id) throws RemoteException;

	public boolean excluirClasses(Long id) throws RemoteException;

	public boolean adicionarClasses(Classes mc) throws RemoteException;

	public boolean alterarClasses(Classes mc) throws RemoteException;
}

