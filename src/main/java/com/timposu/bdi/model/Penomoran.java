package com.timposu.bdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "penomoran")
public class Penomoran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@NotNull
	@Column(nullable = false, name = "nama")
	private String namaKegiatan;

	@NotEmpty
	@Column(name = "nomor")
	private Integer nomor = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaKegiatan() {
		return namaKegiatan;
	}

	public void setNamaKegiatan(String namaKegiatan) {
		this.namaKegiatan = namaKegiatan;
	}

	public Integer getNomor() {
		return nomor;
	}

	public void setNomor(Integer nomor) {
		this.nomor = nomor;
	}
}