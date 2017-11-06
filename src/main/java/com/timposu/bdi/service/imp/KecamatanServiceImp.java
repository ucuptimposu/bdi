package com.timposu.bdi.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.bdi.dao.KecamatanDao;
import com.timposu.bdi.model.Kecamatan;
import com.timposu.bdi.service.KecamatanService;

@Service
@Transactional
public class KecamatanServiceImp implements KecamatanService {
	
	@Autowired
	private KecamatanDao kecamatanDao;

	@Override
	public void save(Kecamatan kecamatan) {
		kecamatanDao.save(kecamatan);
	}

	@Override
	public List<Kecamatan> list() {
		return kecamatanDao.list();
	}

	@Override
	public Kecamatan getKecamatan(Integer id) {
		return kecamatanDao.getKecamatan(id);
	}

	@Override
	public void delete(Integer id) {
		kecamatanDao.delete(id);
	}

}
