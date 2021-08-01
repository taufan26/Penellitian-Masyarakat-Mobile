package app.ppip.penelitian_mobile.model.laporanAkhirPenelitian;

import com.google.gson.annotations.SerializedName;

public class LaporanAkhirPenelitianItem{

	@SerializedName("laporan_akhir_penelitian_id")
	private String laporanAkhirPenelitianId;

	@SerializedName("updated_at")
	private String updatedAt;

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

	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	public String getLaporanAkhirPenelitianId(){
		return laporanAkhirPenelitianId;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public String getUsulanPenelitianJudul(){
		return usulanPenelitianJudul;
	}
}