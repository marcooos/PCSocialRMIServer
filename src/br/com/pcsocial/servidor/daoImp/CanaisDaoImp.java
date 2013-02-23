package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.CanaisDao;
import br.com.pcsocial.servidor.modelo.Canais;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class CanaisDaoImp implements CanaisDao {

	public void save(Canais canais) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(canais);
		t.commit();
	}

	public Canais getCanais(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Canais canais = (Canais) session.load(Canais.class, id);
		canais.toString();
		session.flush();
		session.close();
		return canais;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Canais> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Canais").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Canais canais) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(canais);
		t.commit();
		session.close();
	}

	public void update(Canais canais) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(canais);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Canais> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Canais" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Canais where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Canais where descricao like :text");
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
