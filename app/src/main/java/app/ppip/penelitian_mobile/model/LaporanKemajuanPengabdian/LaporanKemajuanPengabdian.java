package app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LaporanKemajuanPengabdian{

	@SerializedName("LaporanKemajuanPengabdian")
	private List<LaporanKemajuanPengabdianItem> laporanKemajuanPengabdian;

	public List<LaporanKemajuanPengabdianItem> getLaporanKemajuanPengabdian(){
		return laporanKemajuanPengabdian;
	}
}