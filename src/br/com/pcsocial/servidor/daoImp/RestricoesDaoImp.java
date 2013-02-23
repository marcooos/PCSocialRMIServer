package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.RestricoesDao;
import br.com.pcsocial.servidor.modelo.Restricoes;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class RestricoesDaoImp implements RestricoesDao {

	public void save(Restricoes restricoes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(restricoes);
		t.commit();
	}

	public Restricoes getRestricoes(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Restricoes restricoes = (Restricoes) session.load(Restricoes.class, id);
		restricoes.toString();
		session.flush();
		session.close();
		return restricoes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Restricoes> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Restricoes").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Restricoes restricoes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(restricoes);
		t.commit();
		session.close();
	}

	public void update(Restricoes restricoes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(restricoes);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restricoes> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Restricoes" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Restricoes where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Restricoes where descricao like :text");
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

