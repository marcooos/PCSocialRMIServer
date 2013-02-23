package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.pcsocial.servidor.dao.ApartamentoDao;
import br.com.pcsocial.servidor.daoImp.ApartamentoDaoImp;
import br.com.pcsocial.servidor.modelo.Apartamento;
import br.com.pcsocial.servidor.servico.ApartamentoServ;

public class ApartamentoServImp extends UnicastRemoteObject implements ApartamentoServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaApartamentos;
	private ApartamentoDao apartamento;

	public ApartamentoServImp() throws RemoteException {
		super();
		apartamento = new ApartamentoDaoImp();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarApartamentos() throws RemoteException {
		List<Apartamento> lista = apartamento.list();
		listaApartamentos = new ArrayList(lista);
		return listaApartamentos;
	}

	@Override
	public boolean excluirApartamento(Long id) throws RemoteException {
		 apartamento.remove(apartamento.getApartamento(id));
		 return true;
	}

	@Override
	public boolean adicionarApartamento(Apartamento ap) throws RemoteException {
		try {
			apartamento.save(ap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarApartamento(Apartamento ap) throws RemoteException {
		try {
			apartamento.update(ap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Apartamento getApartamento(long id) throws RemoteException {
		return apartamento.getApartamento(id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getListarApartamentos(String text, long valor) throws RemoteException {
		List<Apartamento> lista = apartamento.list(text,valor);
		listaApartamentos = new ArrayList(lista);
		return listaApartamentos;
		
	}

}

