package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Pessoa;

public interface PessoaServ extends Remote {
	
    public boolean validarLogin(String email, String senha) throws RemoteException;
    
    @SuppressWarnings("rawtypes")
	public List getListarPessoas() throws RemoteException;
    
    @SuppressWarnings("rawtypes")
	public List getListarPessoas(Long id) throws RemoteException;
    
    @SuppressWarnings("rawtypes")
	public List getListarPessoas(String text, long valor) throws RemoteException;
    
    public boolean excluirPessoa(Long id) throws RemoteException;
    
    public boolean adicionarPessoa(Pessoa p) throws RemoteException;
    
    public boolean alterarPessoa(Pessoa p) throws RemoteException;
    
}
