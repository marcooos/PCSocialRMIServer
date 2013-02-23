package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Mercado;

public interface MercadoServ  extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarMercados() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarMercados(String text, long valor) throws RemoteException;
	
	public Mercado getMercado(long id) throws RemoteException;

	public boolean excluirMercado(Long id) throws RemoteException;

	public boolean adicionarMercado(Mercado mc) throws RemoteException;

	public boolean alterarMercado(Mercado mc) throws RemoteException;
}


