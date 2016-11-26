package br.quixada.ufc.ws.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("web_service");
	private EntityManager manager = emf.createEntityManager();
	
	public EntityManager getManager() {
		return manager;
	}
	
}
