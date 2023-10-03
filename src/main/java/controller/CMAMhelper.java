package controller;
import model.CMAM;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CMAMhelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CMNM");
	
	public void insertItem(CMAM li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CMAM> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<CMAM> allItems = em.createQuery("SELECT i from CMAM i").getResultList();
		return allItems;
	}
	
	public void deleteItem(CMAM toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CMAM> typedQuery = em.createQuery("select li from CMAM li where li.Make = :selectedMake and li.Model = :selectedModel and li.Year = :selectedYear", CMAM.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		
		typedQuery.setMaxResults(1);
		
		CMAM result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CMAM searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		CMAM found = em.find(CMAM.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(CMAM toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CMAM> searchForItemByMake(String make) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CMAM> typedQuery = em.createQuery("select li from CMAM li where li.make = :selectedMake", CMAM.class);
		
		typedQuery.setParameter("selectedMake", make);
		
		List<CMAM> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<CMAM> searchForItemByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CMAM> typedQuery = em.createQuery("select li from CMAM li where li.model = :selectedModel", CMAM.class);
		
		typedQuery.setParameter("selectedModel", model);
		
		List<CMAM> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<CMAM> searchForItemByYear(String year) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CMAM> typedQuery = em.createQuery("select li from CMAM li where li.year = :selectedYear", CMAM.class);
		
		typedQuery.setParameter("selectedYear", year);
		
		List<CMAM> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
