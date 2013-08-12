package br.com.pcsocial.servidor.dao;

import java.util.Date;
import java.util.List;

import br.com.pcsocial.servidor.modelo.Hospedagem;
import br.com.pcsocial.servidor.modelo.DetHospedagem;
import br.com.pcsocial.servidor.modelo.ReceitaHospedagem;

public interface HospedagemDao {

	public void save(Hospedagem hospedagem, DetHospedagem detHospedagem, ReceitaHospedagem recHospedagem);

	public Hospedagem getHospedagem(long id);

	public List<Hospedagem> list();

	public List<Hospedagem> list(Date dataInicial, Date dataFinal);
	
	public List<Hospedagem> listHospedagemTarifas(Date dataInicial, Date dataFinal);
	
	public void remove(Hospedagem hospedagem);

	public void update(Hospedagem hospedagem, DetHospedagem detHospedagem, ReceitaHospedagem recHospedagem);

}
