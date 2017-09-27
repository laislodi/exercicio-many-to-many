package br.com.tt;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="codigo")
	private String codigo;
	@Column(name="valor")
	private Double valor;
	@Column(name="carga_horaria")
	private Integer cargaHoraria;
	@ManyToMany(mappedBy="cursos")
	List<Aluno> alunos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public void addAluno(Aluno aluno) {
		if (alunos == null) {
			alunos = new ArrayList<Aluno>();
		}
		alunos.add(aluno);
	}
	
	
	
	
	
	
}
