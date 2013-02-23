package br.com.pcsocial.servidor.dao;

import br.com.pcsocial.servidor.modelo.Pessoa;
import java.util.List;

public interface PessoaDao {

    public void save(Pessoa pessoa);

    public Pessoa getPessoa(long id);

    public boolean validarLogin(String email, String senha);

    public List<Pessoa> list();
    
    public List<Pessoa> list(String text, long valor);

    public List<Pessoa> list(Pessoa pessoaLogada, char tipo);
    
    public List<Pessoa> list(Long id);

    public void remove(Pessoa pessoa);

    public void update(Pessoa pessoa);
}
