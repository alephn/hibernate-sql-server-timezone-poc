package com.alephn.standalonetimezonejpa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alephn.standalonetimezonejpa.config.HibernateConnector;
import com.alephn.standalonetimezonejpa.model.Call;
 
public class CallDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CallDAO.class);
 
    public List<Call> listCalls() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Call c");
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                LOGGER.info("list {}", queryList);
                return (List<Call>) queryList;
            }
        } catch (Exception e) {
            LOGGER.error("Error retriving calls", e);
            return null;
        } finally {
            session.close();
        }
    }
 
    public Call findCallById(int id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Call c where c.id = :id");
            query.setParameter("id", id);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Call) queryList.get(0);
            }
        } catch (Exception e) {
            LOGGER.error("Error getting call by id={}", id, e);
            return null;
        } finally {
            session.close();
        }
    }
 
    public void updateCall(Call call) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            session.saveOrUpdate(call);
            session.flush();
        } catch (Exception e) {
            LOGGER.error("Error updating call id={}", call.getId());
        } finally {
            session.close();
        }
    }
 
    public Call addCall(Call call) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(call);
            transaction.commit();
            return call;
        } catch (Exception e) {
            LOGGER.error("Error adding call id={}", call.getId());
            return null;
        }
    }
    
    public void deleteCall(int id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Call c where c.id =:id");
            createQuery.setParameter("id", id);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
        	LOGGER.error("Error deleting call id={}", id);
        } finally {
            session.close();
        }
    }
    
}    