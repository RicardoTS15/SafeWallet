package com.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.bussinesLayer.Count;
import com.app.bussinesLayer.Person;
import com.app.util.HibernateUtil;

public class DaoCount extends DAO {

	@Override
	public void delete(Object o) {
		 Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            Count count = (Count) session.load(Count.class,(Integer)o);
	            session.delete(count);
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
	public Object getById(Object o) {
		 Count c = null;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from Count where countNum = :count";
	            Query query = session.createQuery(queryString);
	            query.setInteger("count",(Integer)o);
	            c = (Count) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return c;
	}

}
