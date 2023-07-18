package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		// Criando os objetos Pessoa (Marcado como comentario pois o banco de dados já possui esses objetos)
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		EntityManager em = emf.createEntityManager(); 
		
		// Adicionando os objetos no banco de dados
		//em.getTransaction().begin(); 
		//em.persist(p1); 
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit(); 
		
		//Buscando um objeto no banco de dado
		Pessoa pessoa = em.find(Pessoa.class, 2); // Busca um Objeto pelo id
		
		System.out.println(pessoa);

		System.out.println("Finalizado!!");
		
		em.close();
		emf.close();
	}
}
