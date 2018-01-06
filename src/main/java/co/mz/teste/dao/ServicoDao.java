/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.teste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.mz.teste.model.Servico;
import mz.co.teste.connection.HibernateUtil;

public class ServicoDao {

	public Long inserir(Servico chamado) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(chamado);
		t.commit();
		return chamado.getId();
	}

	public void alterar(Servico chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Servico c = selecionar(id);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Servico selecionar(long id) {
		return (Servico) HibernateUtil.getSessionFactory().openSession().get(Servico.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Servico> listar() {
		return (List<Servico>) HibernateUtil.getSessionFactory().openSession().createQuery("from Servico").list();
	}
}
