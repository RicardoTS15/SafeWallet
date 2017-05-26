package com.app.dao;

import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.app.bussinesLayer.Person;
import com.app.util.HibernateUtil;



public class DAOPerson extends DAO {

	@Override
	public void delete(Object value) {
		 Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            Person person = (Person) session.load(Person.class,new String(value.toString()));
	            session.delete(person);
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
	public Object getById(Object RFC) {
		 Person p = null;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from person where RFC = :RFC";
	            Query query = session.createQuery(queryString);
	            query.setString("RFC",RFC.toString());
	            p = (Person) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return p;
	}

	
	public static Person getByUsername(Object email) {
		 Person p = null;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            //String queryString = "from person where email= :em";
	            //Query query = session.createQuery(queryString);
	            p=(Person) session.createCriteria(Person.class).add(Restrictions.eq("user.email",email.toString())).uniqueResult();
	            //query.setString("em",email.toString());
	           // p = (Person) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return p;
	}
	
	
	
	

	
	
}
