package app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian;

import com.google.gson.annotations.SerializedName;

public class LaporanKemeajuanPenelitianItem{


	@SerializedName("laporan_kemajuan_base_name")
	private String laporanKemajuanBaseName;


	@SerializedName("laporan_kemajuan_original_name")
	private String laporanKemajuanOriginalName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("laporan_kemajuan_penelitian_id")
	private String laporanKemajuanPenelitianId;

	@SerializedName("laporan_kemajuan_id")
	private String laporanKemajuanId;

	@SerializedName("laporan_kemajuan_date")
	private String laporanKemajuanDate;

	@SerializedName("laporan_kemajuan_extension")
	private String laporanKemajuanExtension;

	@SerializedName("laporan_kemajuan_tipe")
	private String laporanKemajuanTipe;

	public String getLaporanKemajuanBaseName(){
		return laporanKemajuanBaseName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUsulanPenelitianJudul(){
		return usulanPenelitianJudul;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getLaporanKemajuanId(){
		return laporanKemajuanId;
	}

	public String getLaporanKemajuanDate(){
		return laporanKemajuanDate;
	}

	public String getLaporanKemajuanOriginalName() {
		return laporanKemajuanOriginalName;
	}

	public String getLaporanKemajuanPenelitianId() {
		return laporanKemajuanPenelitianId;
	}

	public String getLaporanKemajuanExtension() {
		return laporanKemajuanExtension;
	}

	public String getLaporanKemajuanTipe() {
		return laporanKemajuanTipe;
	}
}