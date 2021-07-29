package app.ppip.penelitian_mobile.interfaces;

import java.util.List;

import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;

public interface LogbookPenelitianView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<LogbookPenelitianItem> datas);
    void onErrorLoading(String message);
}
