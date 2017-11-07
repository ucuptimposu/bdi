package com.timposu.bdi.service;

import java.util.List;

import com.timposu.bdi.model.Kelurahan;

public interface KelurahanService {

	public void save(Kelurahan kelurahan);

	public List<Kelurahan> list();

	public Kelurahan getKelurahan(Integer id);

	public void delete(Integer id);
}
