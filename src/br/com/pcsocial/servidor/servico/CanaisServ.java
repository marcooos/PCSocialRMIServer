package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Canais;

public interface CanaisServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarCanais() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarCanais(String text, long valor) throws RemoteException;

	public Canais getCanais(long id) throws RemoteException;

	public boolean excluirCanais(Long id) throws RemoteException;

	public boolean adicionarCanais(Canais mc) throws RemoteException;

	public boolean alterarCanais(Canais mc) throws RemoteException;
}
