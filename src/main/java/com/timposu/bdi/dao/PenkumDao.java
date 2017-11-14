package com.timposu.bdi.dao;

import java.util.List;

import com.timposu.bdi.model.Penkum;

public interface PenkumDao {

	public void save(Penkum penkum);
	
	public void update(Penkum penkum);
	
	public List<Penkum> list(String tahun) throws Exception;
	
	public Penkum getPenkum(String id);
	
	public void delete(String id);
	
}
