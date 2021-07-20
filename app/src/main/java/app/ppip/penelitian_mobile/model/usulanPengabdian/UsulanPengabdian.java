package app.ppip.penelitian_mobile.model.usulanPengabdian;

import com.google.gson.annotations.SerializedName;

public class UsulanPengabdian{

	@SerializedName("data")
	private DataUsulanPengabdian data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public DataUsulanPengabdian getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}