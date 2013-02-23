package br.com.pcsocial.servidor.dao;

import java.util.List;

import br.com.pcsocial.servidor.modelo.Empresa;

public interface EmpresaDao {

	public void save(Empresa empresa);

	public Empresa getEmpresa(long id);

	public List<Empresa> list();
	
	public List<Empresa> list(String text, long valor);

	public List<Empresa> list(Long id);

	public void remove(Empresa empresa);

	public void update(Empresa empresa);
}
