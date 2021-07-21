package app.ppip.penelitian_mobile;

import java.util.List;

import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;

public interface PenelitianView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<UsulanPenelitianItem> datas);
    void onErrorLoading(String message);
}
