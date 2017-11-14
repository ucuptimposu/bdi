package com.timposu.bdi.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.bdi.dao.PenkumDao;
import com.timposu.bdi.model.Penkum;
import com.timposu.bdi.service.PenkumService;

@Service
@Transactional
public class PenkumServiceImp implements PenkumService {

	@Autowired
	private PenkumDao pd;
	
	@Override
	public void save(Penkum penkum) {
		pd.save(penkum);
	}
	
	@Override
	public void update(Penkum penkum) {
		pd.update(penkum);
	}

	@Override
	public List<Penkum> list(String tahun) throws Exception {
		return pd.list(tahun);
	}

	@Override
	public Penkum getPenkum(String id) {
		return pd.getPenkum(id);
	}

	@Override
	public void delete(String id) {
		pd.delete(id);
	}

}
