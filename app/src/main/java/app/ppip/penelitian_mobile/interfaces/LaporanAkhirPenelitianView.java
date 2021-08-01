package app.ppip.penelitian_mobile.interfaces;

import java.util.List;

import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;

public interface LaporanAkhirPenelitianView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<LaporanAkhirPenelitianItem> datas);
    void onErrorLoading(String message);
}
