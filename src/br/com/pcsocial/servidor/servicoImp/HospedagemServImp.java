package br.com.pcsocial.servidor.servicoImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pcsocial.servidor.dao.HospedagemDao;
import br.com.pcsocial.servidor.daoImp.HospedagemDaoImp;
import br.com.pcsocial.servidor.modelo.DetHospedagem;
import br.com.pcsocial.servidor.modelo.Hospedagem;
import br.com.pcsocial.servidor.modelo.ReceitaHospedagem;
import br.com.pcsocial.servidor.servico.HospedagemServ;

public class HospedagemServImp extends UnicastRemoteObject implements
		HospedagemServ {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private ArrayList listaHospedagems;
	private HospedagemDao hospedagem;

	public HospedagemServImp() throws RemoteException {
		super();
		hospedagem = new HospedagemDaoImp();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarHospedagems() throws RemoteException {
		List<Hospedagem> lista = hospedagem.list();
		listaHospedagems = new ArrayList(lista);
		return listaHospedagems;
	}

	@Override
	public boolean excluirHospedagem(Long id) throws RemoteException {
		hospedagem.remove(hospedagem.getHospedagem(id));
		return true;
	}

	@Override
	public boolean adicionarHospedagem(Hospedagem hospedagem,
			DetHospedagem detHospedagem, ReceitaHospedagem recHospedagem)
			throws RemoteException {
		try {
			this.hospedagem.save(hospedagem, detHospedagem, recHospedagem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterarHospedagem(Hospedagem hospedagem,
			DetHospedagem detHospedagem, ReceitaHospedagem recHospedagem)
			throws RemoteException {
		try {
			this.hospedagem.update(hospedagem, detHospedagem, recHospedagem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Hospedagem getHospedagem(long id) throws RemoteException {
		return hospedagem.getHospedagem(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getListarHospedagems(Date dataInicial, Date dataFinal)
			throws RemoteException {
		List<Hospedagem> lista = hospedagem.list(dataInicial, dataFinal);
		listaHospedagems = new ArrayList(lista);
		return listaHospedagems;
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public List getListarOcupacaoRestricao(Date dataInicial, Date dataFinal)
			throws RemoteException {
		
		return null;
	}
}
