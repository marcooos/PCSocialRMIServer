package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.TemporadaDao;
import br.com.pcsocial.servidor.modelo.Temporada;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class TemporadaDaoImp implements TemporadaDao {

	public void save(Temporada temporada) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(temporada);
		t.commit();
	}

	public Temporada getTemporada(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Temporada temporada = (Temporada) session.load(Temporada.class, id);
		temporada.toString();
		session.flush();
		session.close();
		return temporada;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Temporada> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Temporada").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Temporada temporada) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(temporada);
		t.commit();
		session.close();
	}

	public void update(Temporada temporada) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(temporada);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Temporada> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Temporada" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Temporada where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Temporada where descricao like :text");
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
