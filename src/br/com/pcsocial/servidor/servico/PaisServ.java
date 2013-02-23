package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Pais;

public interface PaisServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarPaises() throws RemoteException;
	
	public boolean excluirPais(Long id) throws RemoteException;

	public boolean adicionarPais(Pais ps) throws RemoteException;

	public boolean alterarPais(Pais ps) throws RemoteException;
}

