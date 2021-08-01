package app.ppip.penelitian_mobile.model.laporanAkhirPenelitian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LaporanAkhirPenelitian{

	@SerializedName("LaporanAkhirPenelitian")
	private List<LaporanAkhirPenelitianItem> laporanAkhirPenelitian;

	public List<LaporanAkhirPenelitianItem> getLaporanAkhirPenelitian(){
		return laporanAkhirPenelitian;
	}
}