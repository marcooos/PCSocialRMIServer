package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Temporada;

public interface TemporadaDao {

	public void save(Temporada temporada);

    public Temporada getTemporada(long id);

    public List<Temporada> list();
    
    public List<Temporada> list(String text, long valor);

    public void remove(Temporada temporada);

    public void update(Temporada temporada);
}
