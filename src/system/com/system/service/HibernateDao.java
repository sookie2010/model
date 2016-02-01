package com.system.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.tags.Page;
import com.system.util.HibernateUtils;

/**
 * 公共的增删改查方法
 * @author 41882
 *
 */
@Repository
public class HibernateDao<T, PK extends Serializable> 
			implements IHibernateDao<T, PK>{
	
	@Autowired(required=true)
	private HibernateUtils hibernateUtils;
	
	@Override
	public void save(T item) {
		Session session = null;
		try{
			session = hibernateUtils.getSession();
			session.save(item);
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		
	}
	@Override
	public void update(T item) {
		Session session = null;
		try{
			session = hibernateUtils.getSession();
			session.update(item);
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
	}
	@Override
	public void saveOrUpdate(T item) {
		Session session = null;
		try{
			session = hibernateUtils.getSession();
			session.saveOrUpdate(item);
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
	}
	@Override
	public void del(T item) {
		Session session = null;
		try{
			session = hibernateUtils.getSession();
			session.delete(item);
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> dir(Class<?> cls) {
		Session session = null;
		List<T> result = null;
		try{
			session = hibernateUtils.getSession();
			result = session.createQuery("from " + cls.getSimpleName()).list();
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> dir(Class<?> cls,Page page){
		Session session = null;
		List<T> result = null;
		long count = 0;
		try{
			session = hibernateUtils.getSession();
			count = (Long) session.createQuery("select count(*) from " + cls.getSimpleName())
					.uniqueResult();
			page.setRowCount(count);
			result = session.createQuery("from " + cls.getSimpleName())
					.setFirstResult(page.getRowStart())
					.setMaxResults(page.getPageSize())
					.list();
			
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<?> cls,PK id) {
		Session session = null;
		T item = null;
		try{
			session = hibernateUtils.getSession();
			item = (T) session.get(cls,id);
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		return item;
	}
	@Override
	public List<?> excuteQuery(String hql,Object[] params){
		Session session = null;
		List<?> result = null;
		try{
			session = hibernateUtils.getSession();
			Query query = session.createQuery(hql);
			if(params != null){
				for(int index=0 ; index<params.length ; index++){
					query.setParameter(index, params[index]);
				}
			}
			result = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		return result;
	}
	@Override
	public List<?> excuteSQLQuery(String sql,Object[] params){
		Session session = null;
		List<?> result = null;
		try{
			session = hibernateUtils.getSession();
			Query query = session.createSQLQuery(sql);
			if(params != null){
				for(int index=0 ; index<params.length ; index++){
					query.setParameter(index, params[index]);
				}
			}
			result = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			hibernateUtils.closeSession(session);
		}
		return result;
	}
}