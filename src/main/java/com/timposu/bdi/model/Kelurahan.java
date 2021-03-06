package com.timposu.bdi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "kelurahan")
public class Kelurahan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	@Column(nullable = false, unique = true)
	@Size(min = 3)
	private String namaKelurahan;

	@ManyToOne
	@JoinColumn(name = "id_kecamatan")
	private Kecamatan kecamatan;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "kelurahan"
			)
	private List<Penkum> listPenkum = new ArrayList<>();	

	public List<Penkum> getListPenkum() {
		return listPenkum;
	}

	public void setListPenkum(List<Penkum> listPenkum) {
		this.listPenkum = listPenkum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaKelurahan() {
		return namaKelurahan;
	}

	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}

	public Kecamatan getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
	
}
