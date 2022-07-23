package com.model;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.UserDetails;
import com.entity.Account;


@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class EntityModel implements EntityRelationship{

	@Override
	public String insertData(UserDetails U,Account A) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("project");
		   EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();
		    em.persist(U);
		    em.persist(A);
		    em.getTransaction().commit();
		    em.close();
		    emf.close();
			return "One to Many relationship is created Successfully";
	}
}
