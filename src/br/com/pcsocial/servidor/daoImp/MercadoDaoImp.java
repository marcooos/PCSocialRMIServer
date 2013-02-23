package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.MercadoDao;
import br.com.pcsocial.servidor.modelo.Mercado;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class MercadoDaoImp implements MercadoDao {

	public void save(Mercado mercado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(mercado);
		t.commit();
	}

	public Mercado getMercado(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Mercado mercado = (Mercado) session.load(Mercado.class, id);
		mercado.toString();
		session.flush();
		session.close();
		return mercado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Mercado> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Mercado").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Mercado mercado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(mercado);
		t.commit();
		session.close();
	}

	public void update(Mercado mercado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(mercado);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercado> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Mercado" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Mercado where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Mercado where descricao like :text");
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
