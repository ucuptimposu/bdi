package com.timposu.bdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "penomoran")
public class Penomoran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nomor_penkum")
	private Integer nomorPenkum = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNomorPenkum() {
		return nomorPenkum;
	}

	public void setNomorPenkum(Integer nomorPenkum) {
		this.nomorPenkum = nomorPenkum;
	}

}
