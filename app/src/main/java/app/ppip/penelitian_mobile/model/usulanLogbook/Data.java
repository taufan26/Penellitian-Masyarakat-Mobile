package app.ppip.penelitian_mobile.model.usulanLogbook;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("usulan_penelitian_id ")
	private String usulanPenelitianId;

	@SerializedName("usulan_penelitian_skema_id ")
	private String usulanPenelitianSkemaId;

	@SerializedName("usulan_penelitian_reviewer_id")
	private String usulanPenelitianReviewerId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_penelitian_status ")
	private String usulanPenelitianStatus;

	@SerializedName("usulan_penelitian_submit ")
	private String usulanPenelitianSubmit;

	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	@SerializedName("usulan_penelitian_mahasiswa_terlibat ")
	private String usulanPenelitianMahasiswaTerlibat;

	@SerializedName("usulan_penelitian_bidang_id  ")
	private String usulanPenelitianBidangId;

	@SerializedName("usulan_penelitian_tahun ")
	private String usulanPenelitianTahun;

	@SerializedName("usulan_penelitian_lama_kegiatan ")
	private String usulanPenelitianLamaKegiatan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("usulan_penelitian_komentar ")
	private Object usulanPenelitianKomentar;

	@SerializedName("usulan_penelitian_kategori")
	private String usulanPenelitianKategori;

	public String getUsulanPenelitianId(){
		return usulanPenelitianId;
	}

	public String getUsulanPenelitianSkemaId(){
		return usulanPenelitianSkemaId;
	}

	public String getUsulanPenelitianReviewerId(){
		return usulanPenelitianReviewerId;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUsulanPenelitianStatus(){
		return usulanPenelitianStatus;
	}

	public String getUsulanPenelitianSubmit(){
		return usulanPenelitianSubmit;
	}

	public String getUsulanPenelitianJudul(){
		return usulanPenelitianJudul;
	}

	public String getUsulanPenelitianMahasiswaTerlibat(){
		return usulanPenelitianMahasiswaTerlibat;
	}

	public String getUsulanPenelitianBidangId(){
		return usulanPenelitianBidangId;
	}

	public String getUsulanPenelitianTahun(){
		return usulanPenelitianTahun;
	}

	public String getUsulanPenelitianLamaKegiatan(){
		return usulanPenelitianLamaKegiatan;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getUsulanPenelitianKomentar(){
		return usulanPenelitianKomentar;
	}

	public String getUsulanPenelitianKategori(){
		return usulanPenelitianKategori;
	}
}