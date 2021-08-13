package app.ppip.penelitian_mobile.model.usulanPenelitian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsulanPenelitianItem{

	@Expose
	@SerializedName("usulan_penelitian_id")
	private String usulanPenelitianId;

	@Expose
	@SerializedName("usulan_penelitian_skema_id")
	private String usulanPenelitianSkemaId;

	@Expose
	@SerializedName("usulan_penelitian_reviewer_id")
	private String usulanPenelitianReviewerId;

	@Expose
	@SerializedName("created_at")
	private String createdAt;

	@Expose
	@SerializedName("usulan_penelitian_status")
	private String usulanPenelitianStatus;

	@Expose
	@SerializedName("usulan_penelitian_submit")
	private String usulanPenelitianSubmit;

	@Expose
	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	@Expose
	@SerializedName("usulan_penelitian_mahasiswa_terlibat")
	private String usulanPenelitianMahasiswaTerlibat;

	@Expose
	@SerializedName("usulan_penelitian_bidang_id")
	private String usulanPenelitianBidangId;

	@Expose
	@SerializedName("usulan_penelitian_tahun")
	private String usulanPenelitianTahun;

	@Expose
	@SerializedName("usulan_penelitian_lama_kegiatan")
	private String usulanPenelitianLamaKegiatan;

	@Expose
	@SerializedName("updated_at")
	private String updatedAt;

	@Expose
	@SerializedName("usulan_penelitian_komentar")
	private String usulanPenelitianKomentar;

	@Expose
	@SerializedName("usulan_penelitian_kategori")
	private String usulanPenelitianKategori;

	@Expose
	@SerializedName("anggota_penelitian_role")
	private String anggotaPenelitianRole;

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

	public String getUsulanPenelitianKomentar(){
		return usulanPenelitianKomentar;
	}

	public String getUsulanPenelitianKategori(){
		return usulanPenelitianKategori;
	}

	public String getAnggotaPenelitianRole() {
		return anggotaPenelitianRole;
	}
}