package br.com.pcsocial.servidor.daoImp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.PessoaDao;
import br.com.pcsocial.servidor.modelo.Pessoa;
import br.com.pcsocial.servidor.util.HibernateUtil;
import org.hibernate.Query;

public class PessoaDaoImp implements PessoaDao {

    @Override
    public void save(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(pessoa);
            t.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public Pessoa getPessoa(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pessoa pessoa = (Pessoa) session.load(Pessoa.class, id);
        pessoa.toString();
        session.flush();
        session.close();
        return pessoa;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Pessoa> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Pessoa order by 1 desc").list();
        try {
            return lista;
        } finally {
            session.close();
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Pessoa> list(Pessoa pessoaLogada,char tipo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("rawtypes")
        List lista = session.createQuery("from Pessoa where Pessoa.id = "+ pessoaLogada.getId() +""
                                       + " and tipo = '"+tipo+"'").list();
        try {
            return lista;
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(pessoa);
            t.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(pessoa);
            t.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean validarLogin(String email, String senha) {
        boolean retorno;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Pessoa where email = :email and senha = :senha");
        q.setString("email", email);
        q.setString("senha", senha);
        retorno = q.list().isEmpty();
        try {
            return retorno;
        } finally {
            session.close();
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> list(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("rawtypes")
        List lista = session.createQuery("from Pessoa where id = "+ id +"").list();
        try {
            return lista;
        } finally {
            session.close();
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Pessoa" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Pessoa where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Pessoa where nomeRazaoSocial like :text " +
        			"or sobreNomeFantasia like :text or email like :text or cpfCnpj like :text");
            q.setString("text", '%' + text.toLowerCase() + '%');
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
		return null;
	}
}