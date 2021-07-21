package app.ppip.penelitian_mobile.model.usulanPenelitian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UsulanPenelitian{

	@SerializedName("UsulanPenelitian")
	private List<UsulanPenelitianItem> usulanPenelitian;

	public List<UsulanPenelitianItem> getUsulanPenelitian(){
		return usulanPenelitian;
	}
}