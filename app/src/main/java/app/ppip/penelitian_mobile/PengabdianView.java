package app.ppip.penelitian_mobile;

import java.util.List;

import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public interface PengabdianView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<DataUsulanPengabdian> datas);
    void onErrorLoading(String message);
}
