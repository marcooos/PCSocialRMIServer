package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.CidadeDao;
import br.com.pcsocial.servidor.daoImp.CidadeDaoImp;
import br.com.pcsocial.servidor.modelo.Cidade;
import br.com.pcsocial.servidor.servico.CidadeServ;

public class CidadeServImp extends UnicastRemoteObject implements CidadeServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaCidades;
	private CidadeDao cidade;

	public CidadeServImp() throws RemoteException {
		super();
		cidade = new CidadeDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarCidades() throws RemoteException {
		List<Cidade> lista = cidade.list();
		listaCidades = new ArrayList(lista);
		return listaCidades;
	}

	@Override
	public boolean excluirCidade(Long id) throws RemoteException {
		 cidade.remove(cidade.getCidade(id));
		 return true;
	}

	@Override
	public boolean adicionarCidade(Cidade cd) throws RemoteException {
		try {
			cidade.save(cd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarCidade(Cidade cd) throws RemoteException {
		try {
			cidade.update(cd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cidade getCidade(long id) throws RemoteException {
		return cidade.getCidade(id);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarCidades(String text, long valor)
			throws RemoteException {
		List<Cidade> lista = cidade.list(text,valor);
		listaCidades = new ArrayList(lista);
		return listaCidades;
	}

}


