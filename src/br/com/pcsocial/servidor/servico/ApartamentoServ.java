package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Apartamento;

public interface ApartamentoServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarApartamentos() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarApartamentos(String text, long valor) throws RemoteException;
	
	public Apartamento getApartamento(long id) throws RemoteException;

	public boolean excluirApartamento(Long id) throws RemoteException;

	public boolean adicionarApartamento(Apartamento ap) throws RemoteException;

	public boolean alterarApartamento(Apartamento ap) throws RemoteException;
}

