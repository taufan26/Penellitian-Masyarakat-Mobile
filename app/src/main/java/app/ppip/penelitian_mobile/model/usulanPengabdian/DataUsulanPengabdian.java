package app.ppip.penelitian_mobile.model.usulanPengabdian;

import com.google.gson.annotations.SerializedName;

public class DataUsulanPengabdian {

	@SerializedName("usulan_pengabdian_mahasiswa_terlibat ")
	private String usulanPengabdianMahasiswaTerlibat;

	@SerializedName("usulan_pengabdian_kategori")
	private String usulanPengabdianKategori;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_pengabdian_bidang_id  ")
	private String usulanPengabdianBidangId;

	@SerializedName("usulan_pengabdian_tahun ")
	private String usulanPengabdianTahun;

	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	@SerializedName("usulan_pengabdian_skema_id ")
	private String usulanPengabdianSkemaId;

	@SerializedName("usulan_pengabdian_status ")
	private String usulanPengabdianStatus;

	@SerializedName("usulan_pengabdian_lama_kegiatan ")
	private String usulanPengabdianLamaKegiatan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("usulan_pengabdian_reviewer_id")
	private String usulanPengabdianReviewerId;

	@SerializedName("usulan_pengabdian_komentar ")
	private String usulanPengabdianKomentar;

	@SerializedName("usulan_pengabdian_submit ")
	private String usulanPengabdianSubmit;

	@SerializedName("usulan_pengabdian_id ")
	private String usulanPengabdianId;

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

	public String getUsulanPengabdianKomentar(){
		return usulanPengabdianKomentar;
	}

	public String getUsulanPengabdianSubmit(){
		return usulanPengabdianSubmit;
	}

	public String getUsulanPengabdianId(){
		return usulanPengabdianId;
	}
}