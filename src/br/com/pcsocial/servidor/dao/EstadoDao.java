package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Estado;

public interface EstadoDao {

    public void save(Estado estado);

    public Estado getEstado(long id);

    public List<Estado> list();

    public void remove(Estado estado);

    public void update(Estado estado);
}
