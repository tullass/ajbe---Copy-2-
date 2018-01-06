package co.mz.teste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Aluno {
	@Id
	@SequenceGenerator(name = "generator_Aluno", sequenceName = "sequence_Aluno", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "generator_Aluno")
	private long id;
	private String nome;
	private String morada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

}
