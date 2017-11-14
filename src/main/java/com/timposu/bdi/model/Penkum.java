package com.timposu.bdi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.timposu.bdi.enumerated.JenisPelaksanaanPenkum;

@Entity
@Table(name = "penkum")
public class Penkum {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@NotNull
	private Integer nomor;

	@NotNull
	private JenisPelaksanaanPenkum jenisPelaksanaan = JenisPelaksanaanPenkum.LANGSUNG;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 3)
	private String sasaran;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 3)
	private String materi;

	@NotNull
	@Column(nullable = false)
	private Integer jumlahPeserta;

	@Temporal(TemporalType.DATE)
	private Date waktu;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 3)
	private String tempat;

	private String ket;

	private String mediaTidakLangsung;

	private String ketTidakLangsung;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 5)
	private String petugas;

	private String kerjaSamaInstansiLain;

	private String img1;

	private String img2;

	private String img3;

	private String img4;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 5)
	private String latitude;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	@Size(min = 5)
	private String longitude;

	@ManyToOne
	@JoinColumn(name = "id_kelurahan")
	private Kelurahan kelurahan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNomor() {
		return nomor;
	}

	public void setNomor(Integer nomor) {
		this.nomor = nomor;
	}

	public JenisPelaksanaanPenkum getJenisPelaksanaan() {
		return jenisPelaksanaan;
	}

	public void setJenisPelaksanaan(JenisPelaksanaanPenkum jenisPelaksanaan) {
		this.jenisPelaksanaan = jenisPelaksanaan;
	}

	public String getSasaran() {
		return sasaran;
	}

	public void setSasaran(String sasaran) {
		this.sasaran = sasaran;
	}

	public String getMateri() {
		return materi;
	}

	public void setMateri(String materi) {
		this.materi = materi;
	}

	public Integer getJumlahPeserta() {
		return jumlahPeserta;
	}

	public void setJumlahPeserta(Integer jumlahPeserta) {
		this.jumlahPeserta = jumlahPeserta;
	}

	public Date getWaktu() {
		return waktu;
	}

	public void setWaktu(Date waktu) {
		this.waktu = waktu;
	}

	public String getTempat() {
		return tempat;
	}

	public void setTempat(String tempat) {
		this.tempat = tempat;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	public String getMediaTidakLangsung() {
		return mediaTidakLangsung;
	}

	public void setMediaTidakLangsung(String mediaTidakLangsung) {
		this.mediaTidakLangsung = mediaTidakLangsung;
	}

	public String getKetTidakLangsung() {
		return ketTidakLangsung;
	}

	public void setKetTidakLangsung(String ketTidakLangsung) {
		this.ketTidakLangsung = ketTidakLangsung;
	}

	public String getPetugas() {
		return petugas;
	}

	public void setPetugas(String petugas) {
		this.petugas = petugas;
	}

	public String getKerjaSamaInstansiLain() {
		return kerjaSamaInstansiLain;
	}

	public void setKerjaSamaInstansiLain(String kerjaSamaInstansiLain) {
		this.kerjaSamaInstansiLain = kerjaSamaInstansiLain;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Kelurahan getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(Kelurahan kelurahan) {
		this.kelurahan = kelurahan;
	}

}
