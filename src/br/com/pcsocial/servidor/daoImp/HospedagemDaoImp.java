package br.com.pcsocial.servidor.daoImp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.pcsocial.servidor.dao.HospedagemDao;
import br.com.pcsocial.servidor.modelo.DetHospedagem;
import br.com.pcsocial.servidor.modelo.Hospedagem;
import br.com.pcsocial.servidor.modelo.ReceitaHospedagem;
import br.com.pcsocial.servidor.util.HibernateUtil;

public class HospedagemDaoImp implements HospedagemDao {

	public void save(Hospedagem hospedagem, DetHospedagem detHospedagem,
			ReceitaHospedagem recHospedagem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		detHospedagem.setHospedagem(hospedagem);
		recHospedagem.setHospedagem(hospedagem);
		session.save(hospedagem);
		session.save(detHospedagem);
		session.save(recHospedagem);
		t.commit();
	}

	public Hospedagem getHospedagem(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Hospedagem hospedagem = (Hospedagem) session.load(Hospedagem.class, id);
		hospedagem.toString(); // inicializar os atributos.
		session.flush();
		session.close();
		return hospedagem;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public List<Hospedagem> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Hospedagem").list();
		try {
			return lista;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Hospedagem> list(Date dataInicial, Date dataFinal) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session
				.createQuery("from Hospedagem " +
						"where (dataEntrada >= :dataInicial or dataSaida<= :dataFinal)");// and "
						//+ " :dataFinal");
		q.setDate("dataInicial", dataInicial);
		q.setDate("dataFinal", dataFinal);
		//q.setDate("dataFinal", dataFinal);
		try {
			return q.list();
		} finally {
			session.close();
		}
	}

	public void remove(Hospedagem hospedagem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(hospedagem);
		t.commit();
		session.close();
	}

	public void update(Hospedagem hospedagem, DetHospedagem detHospedagem,
			ReceitaHospedagem recHospedagem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(hospedagem);
		session.update(detHospedagem);
		session.update(recHospedagem);
		t.commit();
		session.close();
	}

	@Override
	public List<Hospedagem> listHospedagemTarifas(Date dataInicial,
			Date dataFinal) {
		// TODO Auto-generated method stub
		return null;
	}
}
