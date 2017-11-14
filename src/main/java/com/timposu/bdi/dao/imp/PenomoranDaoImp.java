package com.timposu.bdi.dao.imp;

import org.springframework.stereotype.Repository;

import com.timposu.bdi.dao.PenomoranDao;
import com.timposu.bdi.model.Penomoran;

@Repository
public class PenomoranDaoImp extends AbstractImpDao implements PenomoranDao {

	@Override
	public void save(Penomoran p) {
		getSession().saveOrUpdate(p);	
	}

	@Override
	public Penomoran getNomor(Integer id) {
		Penomoran penomoran = getSession().get(Penomoran.class, id);
		return penomoran;
	}

}
