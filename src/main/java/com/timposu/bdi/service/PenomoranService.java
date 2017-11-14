package com.timposu.bdi.service;

import com.timposu.bdi.model.Penomoran;

public interface PenomoranService {
	
	public void save(Penomoran p);
	
	public Penomoran getNomor(Integer id);
}
