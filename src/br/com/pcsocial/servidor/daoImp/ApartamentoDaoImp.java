package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.ApartamentoDao;
import br.com.pcsocial.servidor.modelo.Apartamento;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class ApartamentoDaoImp implements ApartamentoDao {

	public void save(Apartamento apartamento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(apartamento);
		t.commit();
	}

	public Apartamento getApartamento(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Apartamento apartamento = (Apartamento) session.load(Apartamento.class, id);
		apartamento.toString();
		session.flush();
		session.close();
		return apartamento;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Apartamento> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Apartamento").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Apartamento apartamento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(apartamento);
		t.commit();
		session.close();
	}

	public void update(Apartamento apartamento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(apartamento);
		t.commit();
		session.close();
	}

	@Override
	@SuppressWarnings({"unchecked"})
	public List<Apartamento> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Apartamento" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Apartamento where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Apartamento where descricao like :text");
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
