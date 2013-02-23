package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Cidade;

public interface CidadeServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarCidades() throws RemoteException;
	
	@SuppressWarnings("rawtypes")
	public List getListarCidades(String text, long valor) throws RemoteException;
	
	public Cidade getCidade(long id) throws RemoteException;

	public boolean excluirCidade(Long id) throws RemoteException;

	public boolean adicionarCidade(Cidade cd) throws RemoteException;

	public boolean alterarCidade(Cidade cd) throws RemoteException;
}
