package com.timposu.bdi.dao.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractImpDao {

	@Autowired
	private SessionFactory sf;
	
	protected Session getSession() {
		return sf.getCurrentSession();
	}
	
}
