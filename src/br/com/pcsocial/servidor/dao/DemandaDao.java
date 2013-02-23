package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Demanda;

public interface DemandaDao {
	
	public void save(Demanda demanda);

	public Demanda getDemanda(long id);

	public List<Demanda> list();
	
	public List<Demanda> list(String text, long valor);

	public void remove(Demanda demanda);

	public void update(Demanda demanda);
}
