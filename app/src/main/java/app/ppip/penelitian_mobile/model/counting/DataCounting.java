package app.ppip.penelitian_mobile.model.counting;

import com.google.gson.annotations.SerializedName;

public class DataCounting {

	@SerializedName("usulan_pengabdian_count")
	private String usulanPengabdianCount;

	@SerializedName("usulan_penelitian_count")
	private String usulanPenelitianCount;

	@SerializedName("usulan_riwayat_penelitian_count")
	private String usulanRiwayatPenelitianCount;

	@SerializedName("usulan_riwayat_pengabdian_count")
	private String usulanRiwayatPengabdianCount;

	public String getUsulanPengabdianCount(){
		return usulanPengabdianCount;
	}

	public String getUsulanPenelitianCount(){
		return usulanPenelitianCount;
	}

	public String getUsulanRiwayatPenelitianCount(){
		return usulanRiwayatPenelitianCount;
	}

	public String getUsulanRiwayatPengabdianCount(){
		return usulanRiwayatPengabdianCount;
	}
}