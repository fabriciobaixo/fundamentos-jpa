package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Buscando pessoa no banco de dados
		Pessoa p = em.find(Pessoa.class,2);
		
		System.out.println(p);
		
		System.out.println("Pronto");
		em.close();
		emf.close();


	}

}
