package com.timposu.bdi.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.bdi.dao.KelurahanDao;
import com.timposu.bdi.model.Kelurahan;
import com.timposu.bdi.service.KelurahanService;

@Service
@Transactional
public class KelurahanServiceImp implements KelurahanService {

	@Autowired
	private KelurahanDao kd;
	
	@Override
	public void save(Kelurahan kelurahan) {
		kd.save(kelurahan);
	}

	@Override
	public List<Kelurahan> list() {
		return kd.list();
	}

	@Override
	public Kelurahan getKelurahan(Integer id) {
		return kd.getKelurahan(id);
	}

	@Override
	public void delete(Integer id) {
		kd.delete(id);
	}

}
