package br.com.pcsocial.servidor.daoImp;

import br.com.pcsocial.servidor.modelo.Estado;
import br.com.pcsocial.servidor.dao.EstadoDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.util.HibernateUtil;

public class EstadoDaoImp implements EstadoDao {

    public void save(Estado estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(estado);
        t.commit();
    }

    public Estado getEstado(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Estado estado = (Estado) session.load(Estado.class, id);
        estado.toString();
        session.flush();
        session.close();
        return estado;
    }

    @SuppressWarnings({ "rawtypes", "unchecked","unused"})
    public List<Estado> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Estado").list();
        try {
            return lista;
        } finally {
            session.close();
        }
    }

    public void remove(Estado estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(estado);
        t.commit();
    }

    public void update(Estado estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(estado);
        t.commit();
    }
}

