package com.timposu.bdi.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timposu.bdi.dao.KecamatanDao;
import com.timposu.bdi.model.Kecamatan;

@Repository
public class KecamatanDaoImp implements KecamatanDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Kecamatan kecamatan) {
		getSession().saveOrUpdate(kecamatan);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Kecamatan> list() {
		List<Kecamatan> listKecamatan = getSession().
				createCriteria(Kecamatan.class).list();
		return listKecamatan;
	}

	@Override
	public Kecamatan getKecamatan(Integer id) {
		Kecamatan kecamatan = getSession().
				get(Kecamatan.class, id);
		return kecamatan;
	}

	@SuppressWarnings("unused")
	@Override
	public void delete(Integer id) {
		Kecamatan kecamatan = getSession().
				get(Kecamatan.class, id);
		getSession().delete(kecamatan);
	}

}
