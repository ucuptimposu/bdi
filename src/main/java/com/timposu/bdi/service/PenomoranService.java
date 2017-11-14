package com.timposu.bdi.service;

import java.util.List;

import com.timposu.bdi.model.Penomoran;

public interface PenomoranService {
	
	public void save(Penomoran p);
	
	public List<Penomoran> getPenomoran(String value);
}
