package app.ppip.penelitian_mobile.model.usulanPengabdian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUsulanPengabdian {

	@Expose
	@SerializedName("usulan_pengabdian_mahasiswa_terlibat")
	private String usulanPengabdianMahasiswaTerlibat;

	@Expose
	@SerializedName("usulan_pengabdian_kategori")
	private String usulanPengabdianKategori;

	@Expose
	@SerializedName("created_at")
	private String createdAt;

	@Expose
	@SerializedName("usulan_pengabdian_bidang_id")
	private String usulanPengabdianBidangId;

	@Expose
	@SerializedName("usulan_pengabdian_tahun")
	private String usulanPengabdianTahun;

	@Expose
	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	@Expose
	@SerializedName("usulan_pengabdian_skema_id")
	private String usulanPengabdianSkemaId;

	@Expose
	@SerializedName("usulan_pengabdian_status")
	private String usulanPengabdianStatus;

	@Expose
	@SerializedName("usulan_pengabdian_lama_kegiatan")
	private String usulanPengabdianLamaKegiatan;

	@Expose
	@SerializedName("updated_at")
	private String updatedAt;

	@Expose
	@SerializedName("usulan_pengabdian_reviewer_id")
	private String usulanPengabdianReviewerId;

	@Expose
	@SerializedName("usulan_pengabdian_submit")
	private String usulanPengabdianSubmit;

	@Expose
	@SerializedName("usulan_pengabdian_id")
	private String usulanPengabdianId;

	@Expose
	@SerializedName("anggota_pengabdian_role")
	private String anggotaPengabdianRole;

	public String getUsulanPengabdianMahasiswaTerlibat(){
		return usulanPengabdianMahasiswaTerlibat;
	}

	public String getUsulanPengabdianKategori(){
		return usulanPengabdianKategori;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUsulanPengabdianBidangId(){
		return usulanPengabdianBidangId;
	}

	public String getUsulanPengabdianTahun(){
		return usulanPengabdianTahun;
	}

	public String getUsulanPengabdianJudul(){
		return usulanPengabdianJudul;
	}

	public String getUsulanPengabdianSkemaId(){
		return usulanPengabdianSkemaId;
	}

	public String getUsulanPengabdianStatus(){
		return usulanPengabdianStatus;
	}

	public String getUsulanPengabdianLamaKegiatan(){
		return usulanPengabdianLamaKegiatan;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getUsulanPengabdianReviewerId(){
		return usulanPengabdianReviewerId;
	}

	public String getUsulanPengabdianSubmit(){
		return usulanPengabdianSubmit;
	}

	public String getUsulanPengabdianId(){
		return usulanPengabdianId;
	}

	public String getAnggotaPengabdianRole() {
		return anggotaPengabdianRole;
	}
}