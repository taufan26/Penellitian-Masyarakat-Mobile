package app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LaporanKemeajuanPenelitian{

	@SerializedName("LaporanKemeajuanPenelitian")
	private List<LaporanKemeajuanPenelitianItem> laporanKemeajuanPenelitian;

	public List<LaporanKemeajuanPenelitianItem> getLaporanKemeajuanPenelitian(){
		return laporanKemeajuanPenelitian;
	}
}