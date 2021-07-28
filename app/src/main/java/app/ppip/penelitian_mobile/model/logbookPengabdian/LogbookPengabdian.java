package app.ppip.penelitian_mobile.model.logbookPengabdian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LogbookPengabdian{

	@SerializedName("LogbookPengabdian")
	private List<LogbookPengabdianItem> logbookPengabdian;

	public List<LogbookPengabdianItem> getLogbookPengabdian(){
		return logbookPengabdian;
	}
}