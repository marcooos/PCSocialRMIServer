package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Demanda;

public interface DemandaServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarDemandas() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarDemandas(String text, long valor) throws RemoteException;
	
	public Demanda getDemanda(Long id) throws RemoteException;
	
	public boolean excluirDemanda(Long id) throws RemoteException;

	public boolean adicionarDemanda(Demanda dm) throws RemoteException;

	public boolean alterarDemanda(Demanda dm) throws RemoteException;
}

