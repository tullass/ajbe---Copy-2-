package co.mz.teste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.mz.teste.model.TipoDoc;
import mz.co.teste.connection.HibernateUtil;

public class TipoDao {

	public Long inserir(TipoDoc chamado) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(chamado);
		t.commit();
		return chamado.getId();
	}

	public void alterar(TipoDoc chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		TipoDoc c = selecionar(id);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public TipoDoc selecionar(long id) {
		return (TipoDoc) HibernateUtil.getSessionFactory().openSession().get(TipoDoc.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<TipoDoc> listar() {
		return (List<TipoDoc>) HibernateUtil.getSessionFactory().openSession().createQuery("from TipoDoc").list();
	}
}
