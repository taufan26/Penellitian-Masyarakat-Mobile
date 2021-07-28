package app.ppip.penelitian_mobile.interfaces;

import java.util.List;

import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPengabdian.LogbookPengabdianItem;

public interface LogbookPengabdianView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<LogbookPengabdianItem> datas);
    void onErrorLoading(String message);
}
