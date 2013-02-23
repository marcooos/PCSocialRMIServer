package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Tarifa;

public interface TarifaDao {

	public void save(Tarifa tarifa);

	public Tarifa getTarifa(long id);

	public List<Tarifa> list();
	
	public List<Tarifa> list(String text, long valor);

	public void remove(Tarifa tarifa);

	public void update(Tarifa tarifa);
}
