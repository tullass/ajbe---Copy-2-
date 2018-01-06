package co.mz.teste.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoDoc {
	@Id
	@SequenceGenerator(name = "generator_TipoDoc", sequenceName = "sequence_TipoDoc", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "generator_TipoDoc")
	private long id;
	private String tipo;
	GregorianCalendar calendar = new GregorianCalendar();
	private int data = calendar.getWeekYear();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
