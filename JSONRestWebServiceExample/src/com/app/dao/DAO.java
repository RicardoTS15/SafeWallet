package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.app.util.HibernateUtil;

public abstract class DAO {
			public static void Register(Object user) {
		        Transaction trns = null;
		        Session session = HibernateUtil.getSessionFactory().openSession();
		        try {
		            trns = session.beginTransaction();
		            session.save(user);
		            session.getTransaction().commit();
		        } catch (RuntimeException e) {
		            if (trns != null) {
		                trns.rollback();
		            }
		            e.printStackTrace();
		        } finally {
		            session.flush();
		            session.close();
		        }
		    }
			public abstract  void delete(Object o);
			public abstract Object getById(Object o);
			
			
			public void updateUser(Object o) {
		        Transaction trns = null;
		        Session session = HibernateUtil.getSessionFactory().openSession();
		        try {
		            trns = session.beginTransaction();
		            session.update(o);
		            session.getTransaction().commit();
		        } catch (RuntimeException e) {
		            if (trns != null) {
		                trns.rollback();
		            }
		            e.printStackTrace();
		        } finally {
		            session.flush();
		            session.close();
		        }
		    }

}
