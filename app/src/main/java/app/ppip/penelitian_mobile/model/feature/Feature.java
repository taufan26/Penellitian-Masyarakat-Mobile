package app.ppip.penelitian_mobile.model.feature;

import com.google.gson.annotations.SerializedName;

public class Feature{

	@SerializedName("data")
	private FeatureItem item;

	public FeatureItem getData(){
		return item;
	}
}