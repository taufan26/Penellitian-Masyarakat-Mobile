package app.ppip.penelitian_mobile.interfaces;

import java.util.List;

import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;


public interface LaporanKemajuanPenelitainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<LaporanKemeajuanPenelitianItem> datas);
    void onErrorLoading(String message);
}
