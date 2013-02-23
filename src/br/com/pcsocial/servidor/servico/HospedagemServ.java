package br.com.pcsocial.servidor.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import br.com.pcsocial.servidor.modelo.DetHospedagem;
import br.com.pcsocial.servidor.modelo.Hospedagem;
import br.com.pcsocial.servidor.modelo.ReceitaHospedagem;

public interface HospedagemServ extends Remote {

	@SuppressWarnings("rawtypes")
	public List getListarHospedagems() throws RemoteException;

	@SuppressWarnings("rawtypes")
	public List getListarHospedagems(Date dataInicial, Date dataFinal)
			throws RemoteException;

	public Hospedagem getHospedagem(long id) throws RemoteException;

	public boolean excluirHospedagem(Long id) throws RemoteException;

	public boolean adicionarHospedagem(Hospedagem hospedagem, DetHospedagem detHospedagem,
			ReceitaHospedagem recHospedagem) throws RemoteException;

	public boolean alterarHospedagem(Hospedagem hospedagem, DetHospedagem detHospedagem,
			ReceitaHospedagem recHospedagem) throws RemoteException;
}