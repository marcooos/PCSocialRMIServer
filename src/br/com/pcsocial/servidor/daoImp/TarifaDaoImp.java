package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.TarifaDao;
import br.com.pcsocial.servidor.modelo.Tarifa;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class TarifaDaoImp implements TarifaDao {

	public void save(Tarifa tarifa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(tarifa);
		t.commit();
	}

	public Tarifa getTarifa(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Tarifa tarifa = (Tarifa) session.load(Tarifa.class, id);
		tarifa.toString();
		session.flush();
		session.close();
		return tarifa;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Tarifa> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Tarifa").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Tarifa tarifa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(tarifa);
		t.commit();
		session.close();
	}

	public void update(Tarifa tarifa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(tarifa);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarifa> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Tarifa" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Tarifa where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Tarifa where descricao like :text");
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
