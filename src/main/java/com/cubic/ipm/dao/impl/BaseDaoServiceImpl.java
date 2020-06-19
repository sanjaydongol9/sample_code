package com.cubic.ipm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.cubic.ipm.dao.BaseDaoService;




/**
 * @author Surendra J
 *
 * @param <T>
 */
public abstract class BaseDaoServiceImpl<T> implements BaseDaoService<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoServiceImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T find(Long id) {
		return (T) getCurrentSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) getCurrentSession().createCriteria(type).list();
	}

	@Override
	public T save(T t) {
		getCurrentSession().save(t);
		return t;
	}
	
	public T merge(T t) {
		sessionFactory.getCurrentSession().merge(t);
		return t;
	}

	@Override
	public T update(T t) {
		getCurrentSession().saveOrUpdate(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		getCurrentSession().delete((T) getCurrentSession().load(type, id));
	}

	@Override
	public void delete(T t) {
		getCurrentSession().delete(t);
	}

	@Override
	public Long count() {
		return (Long) getCurrentSession().createCriteria(type.getSimpleName())
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


}
