package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Receita;

public interface ReceitaServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarReceitas() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarReceitas(String text, long valor) throws RemoteException;
	
	public Receita getReceita(Long id) throws RemoteException;

	public boolean excluirReceita(Long id) throws RemoteException;

	public boolean adicionarReceita(Receita rc) throws RemoteException;

	public boolean alterarReceita(Receita rc) throws RemoteException;
}
