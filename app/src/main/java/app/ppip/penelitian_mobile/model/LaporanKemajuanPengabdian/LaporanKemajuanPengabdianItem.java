package app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian;

import com.google.gson.annotations.SerializedName;

public class LaporanKemajuanPengabdianItem{

	@SerializedName("laporan_kemajuan_base_name")
	private String laporanKemajuanBaseName;

	@SerializedName("usulan_luaran_pengabdian_id")
	private String usulanLuaranPengabdianId;

	@SerializedName("usulan_luaran_pengabdian_rencana")
	private String usulanLuaranPengabdianRencana;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("usulan_luaran_pengabdian_status")
	private String usulanLuaranPengabdianStatus;

	@SerializedName("usulan_luaran_pengabdian_jenis")
	private String usulanLuaranPengabdianJenis;

	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	@SerializedName("usulan_luaran_pengabdian_tahun")
	private String usulanLuaranPengabdianTahun;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("laporan_kemajuan_luaran_id")
	private String laporanKemajuanLuaranId;

	@SerializedName("usulan_luaran_id")
	private String usulanLuaranId;

	@SerializedName("laporan_kemajuan_id")
	private String laporanKemajuanId;

	@SerializedName("laporan_kemajuan_date")
	private String laporanKemajuanDate;

	@SerializedName("usulan_luaran_pengabdian_tipe")
	private String usulanLuaranPengabdianTipe;

	public String getLaporanKemajuanBaseName(){
		return laporanKemajuanBaseName;
	}

	public String getUsulanLuaranPengabdianId(){
		return usulanLuaranPengabdianId;
	}

	public String getUsulanLuaranPengabdianRencana(){
		return usulanLuaranPengabdianRencana;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUsulanLuaranPengabdianStatus(){
		return usulanLuaranPengabdianStatus;
	}

	public String getUsulanLuaranPengabdianJenis(){
		return usulanLuaranPengabdianJenis;
	}

	public String getUsulanPengabdianJudul(){
		return usulanPengabdianJudul;
	}

	public String getUsulanLuaranPengabdianTahun(){
		return usulanLuaranPengabdianTahun;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public String getUsulanLuaranPengabdianTipe(){
		return usulanLuaranPengabdianTipe;
	}
}