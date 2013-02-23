package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.CidadeDao;
import br.com.pcsocial.servidor.modelo.Cidade;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class CidadeDaoImp implements CidadeDao {

	public void save(Cidade cidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(cidade);
		t.commit();
	}

	public Cidade getCidade(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cidade cidade = (Cidade) session.load(Cidade.class, id);
		cidade.toString(); // inicializar os atributos.  
        session.flush();  
        session.close(); 
		return cidade;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Cidade> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Cidade").list();
		try {
			return lista;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked"})
	public List<Cidade> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Cidade" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Cidade where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Cidade where descricao like :text or " +
        			"estado.descricao like :text or estado.pais.descricao like :text");
            q.setString("text", '%' + text.toLowerCase() + '%');
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
		return null;
	}

	public void remove(Cidade cidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(cidade);
		t.commit();
		session.close();
	}

	public void update(Cidade cidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(cidade);
		t.commit();
		session.close();
	}
}
