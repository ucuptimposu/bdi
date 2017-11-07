package com.timposu.bdi.dao;

import java.util.List;

import com.timposu.bdi.model.Kelurahan;

public interface KelurahanDao {

	public void save(Kelurahan kelurahan);
	
	public List<Kelurahan> list();
	
	public Kelurahan getKelurahan(Integer id);
	
	public void delete(Integer id);
}
