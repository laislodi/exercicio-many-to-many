package br.com.tt;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cpf", length = 14, nullable = false)
	private String cpf;
	@ManyToMany(cascade = ALL)
	// 	@formatter:off
	@JoinTable(
			name="relacao_aluno_curso",
			joinColumns= {@JoinColumn(name="aluno_key")},
			inverseJoinColumns= {@JoinColumn(name="curso_key")}
	)
	private List<Curso> cursos;
	//	@formatter:on
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void addCurso(Curso curso) {
		if (curso != null) {
			if (cursos == null) {
				cursos = new ArrayList<Curso>();
			}
			cursos.add(curso);
			curso.addAluno(this);
		}
	}

}
