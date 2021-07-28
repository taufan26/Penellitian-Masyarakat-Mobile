package app.ppip.penelitian_mobile.model.usulanLogbook;

import com.google.gson.annotations.SerializedName;

public class UsulanLogbook{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}
}