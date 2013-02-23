package br.com.pcsocial.servidor.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.EmpresaDao;
import br.com.pcsocial.servidor.modelo.Empresa;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class EmpresaDaoImp implements EmpresaDao {

	@Override
	public void save(Empresa empresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(empresa);
			t.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public Empresa getEmpresa(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Empresa empresa = (Empresa) session.load(Empresa.class, id);
		empresa.toString();
		session.flush();
		session.close();	
		return empresa;
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Empresa").list();
		try {
			return lista;
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(Empresa empresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(empresa);
			t.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Empresa empresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(empresa);
			t.commit();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> list(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from Empresa where id = " + id + "")
				.list();
		try {
			return lista;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> list(String text, long valor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        if (text.equals("")&&(valor == 0)){
        	Query q = session.createQuery("from Empresa" );
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        } else
		if (text.equals("")){
        	Query q = session.createQuery("from Empresa where id = :valor" );
            q.setLong("valor", valor);
            try {
    			return q.list();
    		} finally {
                session.close();
            }
        }
        if (valor == 0){
        	Query q = session.createQuery("from Empresa where pessoaEmpresa.nomeRazaoSocial like :text " +
        			"or pessoaEmpresa.sobreNomeFantasia like :text or pessoaEmpresa.email like :text " +
        			"or pessoaEmpresa.cpfCnpj like :text");
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
