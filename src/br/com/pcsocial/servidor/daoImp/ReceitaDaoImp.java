package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.ReceitaDao;
import br.com.pcsocial.servidor.modelo.Receita;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class ReceitaDaoImp  implements ReceitaDao {

	public void save(Receita receita) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(receita);
		t.commit();
	}

	public Receita getReceita(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Receita receita =  (Receita) session.load(Receita.class, id);
		receita.toString();
		session.flush();
		session.close();
		return receita;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Receita> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Receita").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Receita receita) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(receita);
		t.commit();
		session.close();
	}

	public void update(Receita receita) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(receita);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Receita> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Receita" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Receita where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Receita where descricao like :text");
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
