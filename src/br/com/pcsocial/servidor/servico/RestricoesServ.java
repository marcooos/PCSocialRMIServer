package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Restricoes;

public interface RestricoesServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarRestricoes() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarRestricoes(String text, long valor) throws RemoteException;

	public Restricoes getRestricoes(long id) throws RemoteException;

	public boolean excluirRestricoes(Long id) throws RemoteException;

	public boolean adicionarRestricoes(Restricoes mc) throws RemoteException;

	public boolean alterarRestricoes(Restricoes mc) throws RemoteException;
}
