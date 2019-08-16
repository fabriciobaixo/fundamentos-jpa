/*
 * Caso esteja usando Java 9 para que o hibernate não acuse problema com jabx
 * adicionar no VM arguments (Run As -> Run Configurations -> Arguments)
 * o seguinte modulo: --add-modules java.xml.bind -->
 */

package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Buscando pessoa no banco de dados
		Pessoa p = em.find(Pessoa.class,2);
		
		//Sempre que uma operacao nao for uma consulta se deve iniciar uma transacao
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		
		System.out.println(p);
		
		System.out.println("Pronto");
		em.close();
		emf.close();


	}

}
