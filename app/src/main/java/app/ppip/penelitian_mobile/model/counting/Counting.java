package app.ppip.penelitian_mobile.model.counting;

import com.google.gson.annotations.SerializedName;

public class Counting{

	@SerializedName("dataCounting")
	private DataCounting dataCounting;

	public DataCounting getDataCounting(){
		return dataCounting;
	}
}