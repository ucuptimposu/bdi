package com.timposu.bdi.dao;

import com.timposu.bdi.model.Penomoran;

public interface PenomoranDao {

	public void save(Penomoran p);
	
	public Penomoran getPenomoran(Integer id);
	
}
