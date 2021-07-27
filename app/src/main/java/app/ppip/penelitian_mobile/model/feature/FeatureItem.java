package app.ppip.penelitian_mobile.model.feature;

import com.google.gson.annotations.SerializedName;

public class FeatureItem{

	@SerializedName("unlock_feature_end_year")
	private String unlockFeatureEndYear;

	@SerializedName("unlock_feature_end_time  ")
	private String unlockFeatureEndTime;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("unlock_feature_start_year")
	private String unlockFeatureStartYear;

	@SerializedName("unlock_feature_id ")
	private String unlockFeatureId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("unlock_feature_name")
	private String unlockFeatureName;

	@SerializedName("unlock_feature_start_time ")
	private String unlockFeatureStartTime;

	public String getUnlockFeatureEndYear(){
		return unlockFeatureEndYear;
	}

	public String getUnlockFeatureEndTime(){
		return unlockFeatureEndTime;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getUnlockFeatureStartYear(){
		return unlockFeatureStartYear;
	}

	public String getUnlockFeatureId(){
		return unlockFeatureId;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getUnlockFeatureName(){
		return unlockFeatureName;
	}

	public String getUnlockFeatureStartTime(){
		return unlockFeatureStartTime;
	}
}