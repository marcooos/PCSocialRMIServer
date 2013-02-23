package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Temporada;

public interface TemporadaServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarTemporadas() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarTemporadas(String text, long valor) throws RemoteException;
	
	public Temporada getTemporada(Long id) throws RemoteException;
	
	public boolean excluirTemporada(Long id) throws RemoteException;

	public boolean adicionarTemporada(Temporada tp) throws RemoteException;

	public boolean alterarTemporada(Temporada tp) throws RemoteException;
}