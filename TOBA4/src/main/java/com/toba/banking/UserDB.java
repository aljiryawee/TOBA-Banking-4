package com.toba.banking;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class UserDB {

	public static void insert(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (PersistenceException e) {

			Throwable t = getLastThrowable(e);  //fetching Internal Exception
			SQLException exxx = (SQLException) t;  
			System.out.println("SQLstate "+exxx.getSQLState());
			System.out.println(e);
			if(trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	private static Throwable getLastThrowable(Exception e) {
		Throwable t = null;
		for (t = e.getCause(); t.getCause() != null; t = t.getCause())
			;
		return t;
	}

	public static void update(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static User selectUser(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u FROM User u " + "WHERE u.username = :username";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("username", username);
		try {
			User user = q.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public static boolean userExists(String userName) {
		User u = selectUser(userName);
		return u != null;
	}
}
