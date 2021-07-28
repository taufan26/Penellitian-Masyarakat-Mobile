package app.ppip.penelitian_mobile.model.logbookPenelitian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LogbookPenelitian{

	@SerializedName("LogbookPenelitian")
	private List<LogbookPenelitianItem> logbookPenelitian;

	public List<LogbookPenelitianItem> getLogbookPenelitian(){
		return logbookPenelitian;
	}
}