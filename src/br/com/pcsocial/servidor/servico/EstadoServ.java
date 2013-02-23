package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Estado;

public interface EstadoServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarEstados() throws RemoteException;

	public boolean excluirEstado(Long id) throws RemoteException;

	public boolean adicionarEstado(Estado es) throws RemoteException;

	public boolean alterarEstado(Estado es) throws RemoteException;
}
