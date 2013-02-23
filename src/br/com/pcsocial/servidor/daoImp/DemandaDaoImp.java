package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.DemandaDao;
import br.com.pcsocial.servidor.modelo.Demanda;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class DemandaDaoImp implements DemandaDao {

	public void save(Demanda demanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(demanda);
			t.commit();
		} finally {
			session.close();
		}
	}

	public Demanda getDemanda(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Demanda demanda = (Demanda) session.load(Demanda.class, id);
        demanda.toString();
        session.flush();
		session.close();
		return demanda;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Demanda> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Demanda").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Demanda demanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
            session.delete(demanda);
            t.commit();
        } finally {
            session.close();
        }
	}

	public void update(Demanda demanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(demanda);
		try {
            session.update(demanda);
            t.commit();
        } finally {
            session.close();
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demanda> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Demanda" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Demanda where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Demanda where descricao like :text");
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
