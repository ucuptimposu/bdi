package com.timposu.bdi.dao.imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.timposu.bdi.dao.PenkumDao;
import com.timposu.bdi.model.Penkum;

@Repository
public class PenkumDaoImp extends AbstractImpDao implements PenkumDao {

	@Override
	public void save(Penkum penkum) {
		getSession().saveOrUpdate(penkum);	
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Penkum> list(String tahun) throws Exception {
		
		if (tahun.equals("now")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Date date = new Date();
			tahun = dateFormat.format(date);
		}
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date min = formatter.parse(tahun + "-01-01");
		Date max = formatter.parse(tahun + "-12-31");
		
		List<Penkum> listPenkum  = getSession()
				.createCriteria(Penkum.class)
				.add(Restrictions.between("waktu", min, max))
				.list();
		return listPenkum;
	}

	@Override
	public Penkum getPenkum(String id) {
		Penkum penkum = getSession().get(Penkum.class, id);
		return penkum;
	}

	@Override
	public void delete(String id) {
		Penkum penkum = getSession().get(Penkum.class, id);
		getSession().delete(penkum);
	}

}
