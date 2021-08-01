package app.ppip.penelitian_mobile.model.laporanAkhirPengabdian;

import com.google.gson.annotations.SerializedName;

public class LaporanAkhirPengabdianItem{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("laporan_akhir_pengabdian_id")
	private String laporanAkhirPengabdianId;

	@SerializedName("laporan_akhir_date")
	private String laporanAkhirDate;

	@SerializedName("laporan_akhir_original_name")
	private String laporanAkhirOriginalName;

	@SerializedName("laporan_akhir_base_name")
	private String laporanAkhirBaseName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("laporan_akhir_id")
	private String laporanAkhirId;

	@SerializedName("laporan_akhir_extension")
	private String laporanAkhirExtension;

	@SerializedName("laporan_akhir_hash_name")
	private String laporanAkhirHashName;

	@SerializedName("laporan_akhir_file_size")
	private String laporanAkhirFileSize;

	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getLaporanAkhirPengabdianId(){
		return laporanAkhirPengabdianId;
	}

	public String getLaporanAkhirDate(){
		return laporanAkhirDate;
	}

	public String getLaporanAkhirOriginalName(){
		return laporanAkhirOriginalName;
	}

	public String getLaporanAkhirBaseName(){
		return laporanAkhirBaseName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLaporanAkhirId(){
		return laporanAkhirId;
	}

	public String getLaporanAkhirExtension(){
		return laporanAkhirExtension;
	}

	public String getLaporanAkhirHashName(){
		return laporanAkhirHashName;
	}

	public String getLaporanAkhirFileSize(){
		return laporanAkhirFileSize;
	}

	public String getUsulanPengabdianJudul(){
		return usulanPengabdianJudul;
	}
}