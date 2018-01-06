package co.mz.teste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.mz.teste.model.Fatura;
import co.mz.teste.model.Servico;
import co.mz.teste.model.TipoDoc;
import mz.co.teste.connection.HibernateUtil;

public class FaturaDao {
	public Long inserir(Fatura chamado) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(chamado);
		t.commit();
		return chamado.getId();
	}


	public void alterar(Fatura chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Fatura c = selecionar(id);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Fatura selecionar(long id) {
		return (Fatura) HibernateUtil.getSessionFactory().openSession().get(Fatura.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Fatura> listar() {
		return (List<Fatura>) HibernateUtil.getSessionFactory().openSession().createQuery("from Fatura").list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Servico> listarSer() {
		return (List<Servico>) HibernateUtil.getSessionFactory().openSession().createQuery("from Servico").list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<TipoDoc> listene() {
		return (List<TipoDoc>) HibernateUtil.getSessionFactory().openSession().createQuery("from TipoDoc").list();
	}
}
