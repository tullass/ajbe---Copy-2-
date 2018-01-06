package co.mz.teste.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Fatura {

	@Id
	@SequenceGenerator(name = "generator_Fatura", sequenceName = "sequence_Fatura", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "generator_Fatura")
	private long id;
	GregorianCalendar calendar = new GregorianCalendar();
	private int data = calendar.getWeekYear();
	private double subtotal;
	private double total;
	@ManyToOne
	private Servico servico;

	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private TipoDoc tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public TipoDoc getTipo() {
		return tipo;
	}

	public void setTipo(TipoDoc tipo) {
		this.tipo = tipo;
	}

}
