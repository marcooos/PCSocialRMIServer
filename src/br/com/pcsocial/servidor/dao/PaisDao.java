package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Pais;

public interface PaisDao {

    public void save(Pais pais);

    public Pais getPais(long id);

    public List<Pais> list();

    public void remove(Pais pais);

    public void update(Pais pais);
}
