package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Classes;

public interface ClassesDao {

	public void save(Classes classes);

    public Classes getClasses(long id);

    public List<Classes> list();
    
    public List<Classes> list(String text, long valor);

    public void remove(Classes classes);

    public void update(Classes classes);
}

