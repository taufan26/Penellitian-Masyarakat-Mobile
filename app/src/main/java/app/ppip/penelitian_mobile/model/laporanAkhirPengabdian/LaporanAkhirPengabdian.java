package app.ppip.penelitian_mobile.model.laporanAkhirPengabdian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LaporanAkhirPengabdian{

	@SerializedName("LaporanAkhirPengabdian")
	private List<LaporanAkhirPengabdianItem> laporanAkhirPengabdian;

	public List<LaporanAkhirPengabdianItem> getLaporanAkhirPengabdian(){
		return laporanAkhirPengabdian;
	}
}