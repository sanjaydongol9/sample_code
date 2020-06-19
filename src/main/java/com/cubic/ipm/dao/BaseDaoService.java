package com.cubic.ipm.dao;

import java.util.List;

import org.hibernate.Session;

/**
 * @author Surendra J
 *
 * @param <K>
 * @param <T>
 */
public interface BaseDaoService<T> {
		
		/* Find By Primary Key */
	 	public T find(Long id);
	 	
	 	/* Find all */
	    public List<T> findAll();
	    
	    /* Save the entity */
	    public T save(T value);
	    
	    /* update the table */
	    public T update(T value);
	    
	    /* Delete by object */
	    public void delete(T value);
	    
	    /* Delete by Id */ 
	    public void delete(Long id);
	    
	    /* Return total record */
	    public Long count(); 
	    
	    /* Get Current Session Method, for Code Reuse */
	    public Session getCurrentSession();
	    
	    public T merge(T t);

}
