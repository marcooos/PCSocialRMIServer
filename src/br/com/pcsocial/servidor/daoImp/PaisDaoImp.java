package br.com.pcsocial.servidor.daoImp;

import br.com.pcsocial.servidor.modelo.Pais;
import br.com.pcsocial.servidor.dao.PaisDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.util.HibernateUtil;

public class PaisDaoImp implements PaisDao {

    public void save(Pais pais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pais);
        t.commit();
    }

    public Pais getPais(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pais pais =  (Pais) session.load(Pais.class, id);
        pais.toString();
        session.flush();
        session.close();
        return pais;
    }

    @SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Pais> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Pais").list();
        try {
            return lista;
        } finally {
            session.close();
        }
    }

    public void remove(Pais pais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pais);
        t.commit();
    }

    public void update(Pais pais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pais);
        t.commit();
    }
}
