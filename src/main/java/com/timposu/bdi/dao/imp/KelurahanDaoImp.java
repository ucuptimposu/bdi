package com.timposu.bdi.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timposu.bdi.dao.KelurahanDao;
import com.timposu.bdi.model.Kelurahan;

@Repository
public class KelurahanDaoImp implements KelurahanDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Kelurahan kelurahan) {
		getSession().saveOrUpdate(kelurahan);	
	}

	@SuppressWarnings({ "unchecked", "deprecation"})
	@Override
	public List<Kelurahan> list() {
		List<Kelurahan> listKelurahan = getSession().
				createCriteria(Kelurahan.class).list();
		return listKelurahan;
	}

	@Override
	public Kelurahan getKelurahan(Integer id) {
		Kelurahan kelurahan = getSession().
				get(Kelurahan.class, id);
		return kelurahan;
	}

	@Override
	public void delete(Integer id) {
		Kelurahan kelurahan = getSession().
				get(Kelurahan.class, id);
		getSession().delete(kelurahan);
	}

}
