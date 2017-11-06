package com.timposu.bdi.dao;

import java.util.List;

import com.timposu.bdi.model.Kecamatan;

public interface KecamatanDao {

	public void save(Kecamatan kecamatan);
	
	public List<Kecamatan> list();
	
	public Kecamatan getKecamatan(Integer id);
	
	public void delete(Integer id);
}
