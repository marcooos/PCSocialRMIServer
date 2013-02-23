package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Apartamento;

public interface ApartamentoDao {

	    public void save(Apartamento apartamento);

	    public Apartamento getApartamento(long id);

	    public List<Apartamento> list();
	    
	    public List<Apartamento> list(String text, long valor);

	    public void remove(Apartamento apartamento);

	    public void update(Apartamento apartamento);

}
