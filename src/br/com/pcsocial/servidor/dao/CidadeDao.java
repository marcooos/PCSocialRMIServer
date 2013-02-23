package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Cidade;

public interface CidadeDao {

    public void save(Cidade cidade);

    public Cidade getCidade(long id);

    public List<Cidade> list();

    public List<Cidade> list(String text, long valor);

    public void remove(Cidade cidade);

    public void update(Cidade cidade);
}