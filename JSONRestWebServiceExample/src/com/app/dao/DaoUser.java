package com.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.bussinesLayer.Person;
import com.app.bussinesLayer.User;
import com.app.util.HibernateUtil;

public class DaoUser extends DAO {

	@Override
	public void delete(Object value) {
		 Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            User u = (User) session.load(User.class,new String(value.toString()));
	            session.delete(u);
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

	@Override
	public Object getById(Object em) {
		 Person p = null;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from user where email =:e";
	            Query query = session.createQuery(queryString);
	            query.setString("e",em.toString());
	            p = (Person) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return p;
	}

}
