package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mvc");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public AdminPOJO getAdmin() {

		openConnection();
		entityTransaction.begin();

		String jpql = "from AdminPOJO";
		query = entityManager.createQuery(jpql);
		List<AdminPOJO> adminPOJOs = query.getResultList();

		if (adminPOJOs.isEmpty() == false) {
			for (AdminPOJO adminPOJO : adminPOJOs) {
				entityTransaction.commit();
				closeConnection();
				return adminPOJO;
			}
		}
		entityTransaction.commit();
		closeConnection();
		return null;
	}

	public AdminPOJO createAccount(String username, String password) {

		openConnection();
		entityTransaction.begin();

		AdminPOJO adminPOJO = new AdminPOJO();
		adminPOJO.setUsername(username);
		adminPOJO.setPassword(password);

		entityManager.persist(adminPOJO);

		entityTransaction.commit();
		closeConnection();
		return null;
	}

	public AdminPOJO login(String username, String password) {

		openConnection();
		entityTransaction.begin();

		String jpql = "from AdminPOJO " + "where username = '" + username + "' " + "and password = '" + password + "'";
		query = entityManager.createQuery(jpql);

		List<AdminPOJO> adminPOJOs = query.getResultList();
		if (adminPOJOs.isEmpty() == false) {
			for (AdminPOJO adminPOJO : adminPOJOs) {
				entityTransaction.commit();
				closeConnection();
				return adminPOJO;
			}
		}

		entityTransaction.commit();
		closeConnection();
		return null;
	}

}
