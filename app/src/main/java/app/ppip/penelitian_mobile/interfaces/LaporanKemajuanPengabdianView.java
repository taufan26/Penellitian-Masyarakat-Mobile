package app.ppip.penelitian_mobile.interfaces;

import java.util.List;

import app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian.LaporanKemajuanPengabdianItem;

public interface LaporanKemajuanPengabdianView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<LaporanKemajuanPengabdianItem> datas);
    void onErrorLoading(String message);
}
