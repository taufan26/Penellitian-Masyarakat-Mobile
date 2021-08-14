package app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian;

import com.google.gson.annotations.SerializedName;

public class LaporanKemajuanPengabdianItem{

	@SerializedName("laporan_kemajuan_base_name")
	private String laporanKemajuanBaseName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("laporan_kemajuan_id")
	private String laporanKemajuanId;

	@SerializedName("laporan_kemajuan_date")
	private String laporanKemajuanDate;

	@SerializedName("laporan_kemajuan_original_name")
	private String laporanKemajuanOriginalName;

	@SerializedName("laporan_kemajuan_extension")
	private String laporanKemajuanExtension;

	public String getLaporanKemajuanBaseName(){
		return laporanKemajuanBaseName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLaporanKemajuanOriginalName() {
		return laporanKemajuanOriginalName;
	}

	public String getUsulanPengabdianJudul(){
		return usulanPengabdianJudul;
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

	public String getLaporanKemajuanExtension() {
		return laporanKemajuanExtension;
	}
}