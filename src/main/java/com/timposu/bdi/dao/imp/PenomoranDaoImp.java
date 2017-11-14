package com.timposu.bdi.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timposu.bdi.dao.PenomoranDao;
import com.timposu.bdi.model.Penomoran;

@Repository
public class PenomoranDaoImp implements PenomoranDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void save(Penomoran p) {
		sf.getCurrentSession().saveOrUpdate(p);	
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Penomoran> getNomor(String value) {
		List<Penomoran> nomor = sf.getCurrentSession()
				.createCriteria(Penomoran.class)
				.add(Restrictions.like("nama", value)).list();
		return nomor;
	}

}
