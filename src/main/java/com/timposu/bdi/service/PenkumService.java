package com.timposu.bdi.service;

import java.util.List;

import com.timposu.bdi.model.Penkum;

public interface PenkumService {

	public void save(Penkum penkum);
	
	public List<Penkum> list(String tahun) throws Exception;
	
	public Penkum getPenkum(String id);
	
	public void delete(String id);
}
