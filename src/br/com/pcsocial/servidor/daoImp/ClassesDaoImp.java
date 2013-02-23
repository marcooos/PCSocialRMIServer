package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.ClassesDao;
import br.com.pcsocial.servidor.modelo.Classes;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class ClassesDaoImp implements ClassesDao {

	public void save(Classes classes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(classes);
		t.commit();
	}

	public Classes getClasses(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Classes classes = (Classes) session.load(Classes.class, id);
		classes.toString();
		session.flush();
		session.close();
		return classes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked","unused"})
	public List<Classes> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Classes").list();
		try {
            return lista;
        } finally {
            session.close();
        }
	}

	public void remove(Classes classes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(classes);
		t.commit();
		session.close();
	}

	public void update(Classes classes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(classes);
		t.commit();
		session.close();
	}

	@SuppressWarnings({"unchecked"})
	public List<Classes> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Classes" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Classes where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Classes where descricao like :text");
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
