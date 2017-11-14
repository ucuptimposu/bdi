package com.timposu.bdi.dao;

import java.util.List;

import com.timposu.bdi.model.Penomoran;

public interface PenomoranDao {

	public void save(Penomoran p);
	
	public List<Penomoran> getNomor(String value);
	
}
