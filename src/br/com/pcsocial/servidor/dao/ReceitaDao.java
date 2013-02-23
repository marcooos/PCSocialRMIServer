package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Receita;

public interface ReceitaDao {

	public void save(Receita receita);

    public Receita getReceita(long id);

    public List<Receita> list(String text, long valor);
    
    public List<Receita> list();

    public void remove(Receita receita);

    public void update(Receita receita);
}
