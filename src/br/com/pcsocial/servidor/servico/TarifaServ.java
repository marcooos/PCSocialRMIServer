package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Tarifa;

public interface TarifaServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarTarifa() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarTarifa(String text, long valor) throws RemoteException;

	public Tarifa getTarifa(long id) throws RemoteException;

	public boolean excluirTarifa(Long id) throws RemoteException;

	public boolean adicionarTarifa(Tarifa tr) throws RemoteException;

	public boolean alterarTarifa(Tarifa tr) throws RemoteException;
}
