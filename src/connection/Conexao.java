package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	public static EntityManager getConnection(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(name);
		return emf.createEntityManager();
	}

}
