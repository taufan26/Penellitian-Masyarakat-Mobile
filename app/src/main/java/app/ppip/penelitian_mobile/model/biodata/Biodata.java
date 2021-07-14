package app.ppip.penelitian_mobile.model.biodata;

import com.google.gson.annotations.SerializedName;

public class Biodata {

	@SerializedName("data")
	private DataBio data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public DataBio getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}