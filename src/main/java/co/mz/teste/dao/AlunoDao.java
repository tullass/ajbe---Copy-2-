/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.teste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.mz.teste.model.Aluno;
import mz.co.teste.connection.HibernateUtil;

public class AlunoDao {

	public Long inserir(Aluno chamado) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(chamado);
		t.commit();
		return chamado.getId();
	}

	public void alterar(Aluno chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Aluno c = selecionar(id);

		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Aluno selecionar(long id) {
		return (Aluno) HibernateUtil.getSessionFactory().openSession().get(Aluno.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Aluno> listar() {
		return (List<Aluno>) HibernateUtil.getSessionFactory().openSession().createQuery("from Aluno").list();
	}


}
