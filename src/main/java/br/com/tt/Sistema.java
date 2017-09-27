package br.com.tt;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Sistema {
	public static void main(String[] args) {
		System.out.println("Iniciando Sistema...");
		
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		aluno.setName("Lais Gabrielle Lodi");
		aluno.setCpf("104.959.947-07");
		curso.setNome("JPA - Hibernate");
		curso.setCodigo("123456");
		curso.setCargaHoraria(32);
		curso.setValor(786.60d);
		aluno.addCurso(curso);
		
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
		em.clear();
		em.close();
		
	}
}
