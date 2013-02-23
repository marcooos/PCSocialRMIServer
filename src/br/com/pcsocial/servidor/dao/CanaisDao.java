package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Canais;

public interface CanaisDao {

	public void save(Canais canais);

	public Canais getCanais(long id);

	public List<Canais> list();
	
	public List<Canais> list(String text, long valor);

	public void remove(Canais canais);

	public void update(Canais canais);
}
