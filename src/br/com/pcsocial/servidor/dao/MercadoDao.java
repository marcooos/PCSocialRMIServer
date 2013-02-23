package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Mercado;

public interface MercadoDao {

	public void save(Mercado mercado);

    public Mercado getMercado(long id);

    public List<Mercado> list();
    
    public List<Mercado> list(String text, long valor);

    public void remove(Mercado mercado);

    public void update(Mercado mercado);
}
