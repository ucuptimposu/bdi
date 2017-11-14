package com.timposu.bdi.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.bdi.dao.PenomoranDao;
import com.timposu.bdi.model.Penomoran;
import com.timposu.bdi.service.PenomoranService;

@Service
@Transactional
public class PenomoranServiceImp implements PenomoranService {

	@Autowired
	private PenomoranDao pd;
	
	@Override
	public void save(Penomoran p) {
		pd.save(p);
	}

	@Override
	public List<Penomoran> getPenomoran(String value) {
		return pd.getNomor(value);
	}

}
