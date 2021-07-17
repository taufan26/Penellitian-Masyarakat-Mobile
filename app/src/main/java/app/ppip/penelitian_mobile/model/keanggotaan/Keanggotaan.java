package app.ppip.penelitian_mobile.model.keanggotaan;

import com.google.gson.annotations.SerializedName;

public class Keanggotaan {

	@SerializedName("data")
	private DataAnggota data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;


	public DataAnggota getDataAnggota(){
		return data;
	}


	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}