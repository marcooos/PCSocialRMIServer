package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Restricoes;

public interface RestricoesDao {

	public void save(Restricoes restricoes);

    public Restricoes getRestricoes(long id);

    public List<Restricoes> list();
    
    public List<Restricoes> list(String text, long valor);

    public void remove(Restricoes restricoes);

    public void update(Restricoes restricoes);
}
