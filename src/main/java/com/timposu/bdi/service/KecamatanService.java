package com.timposu.bdi.service;

import java.util.List;

import com.timposu.bdi.model.Kecamatan;

public interface KecamatanService {
	
public void save(Kecamatan kecamatan);
	
	public List<Kecamatan> list();
	
	public Kecamatan getKecamatan(Integer id);
	
	public void delete(Integer id);

}
