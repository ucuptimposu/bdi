package com.timposu.bdi.dao.imp;

import org.hibernate.SessionFactory;
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

	@Override
	public Penomoran getPenomoran(Integer id) {
		Penomoran penomoran = sf.getCurrentSession()
				.get(Penomoran.class, id);
		return penomoran;
	}

}
