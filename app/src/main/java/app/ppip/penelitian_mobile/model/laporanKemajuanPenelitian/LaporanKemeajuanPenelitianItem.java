package app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian;

import com.google.gson.annotations.SerializedName;

public class LaporanKemeajuanPenelitianItem{

	@SerializedName("usulan_luaran_penelitian_status")
	private String usulanLuaranPenelitianStatus;

	@SerializedName("laporan_kemajuan_base_name")
	private String laporanKemajuanBaseName;


	@SerializedName("laporan_kemajuan_original_name")
	private String laporanKemajuanOriginalName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_luaran_penelitian_jenis")
	private String usulanLuaranPenelitianJenis;

	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	@SerializedName("usulan_luaran_penelitian_tipe")
	private String usulanLuaranPenelitianTipe;

	@SerializedName("usulan_luaran_penelitian_tahun")
	private String usulanLuaranPenelitianTahun;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("usulan_luaran_penelitian_id")
	private String usulanLuaranPenelitianId;

	@SerializedName("laporan_kemajuan_luaran_id")
	private String laporanKemajuanLuaranId;

	@SerializedName("usulan_luaran_id")
	private String usulanLuaranId;

	@SerializedName("laporan_kemajuan_id")
	private String laporanKemajuanId;

	@SerializedName("laporan_kemajuan_date")
	private String laporanKemajuanDate;

	@SerializedName("usulan_luaran_penelitian_rencana")
	private String usulanLuaranPenelitianRencana;

	public String getUsulanLuaranPenelitianStatus(){
		return usulanLuaranPenelitianStatus;
	}

	public String getLaporanKemajuanBaseName(){
		return laporanKemajuanBaseName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUsulanLuaranPenelitianJenis(){
		return usulanLuaranPenelitianJenis;
	}

	public String getUsulanPenelitianJudul(){
		return usulanPenelitianJudul;
	}

	public String getUsulanLuaranPenelitianTipe(){
		return usulanLuaranPenelitianTipe;
	}

	public String getUsulanLuaranPenelitianTahun(){
		return usulanLuaranPenelitianTahun;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getUsulanLuaranPenelitianId(){
		return usulanLuaranPenelitianId;
	}

	public String getLaporanKemajuanLuaranId(){
		return laporanKemajuanLuaranId;
	}

	public String getUsulanLuaranId(){
		return usulanLuaranId;
	}

	public String getLaporanKemajuanId(){
		return laporanKemajuanId;
	}

	public String getLaporanKemajuanDate(){
		return laporanKemajuanDate;
	}

	public String getUsulanLuaranPenelitianRencana(){
		return usulanLuaranPenelitianRencana;
	}

	public String getLaporanKemajuanOriginalName() {
		return laporanKemajuanOriginalName;
	}
}