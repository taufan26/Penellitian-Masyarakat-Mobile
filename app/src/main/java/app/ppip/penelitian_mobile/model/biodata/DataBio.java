package app.ppip.penelitian_mobile.model.biodata;

import com.google.gson.annotations.SerializedName;

public class DataBio {

	@SerializedName("biodata_college")
	private String biodataCollege;

	@SerializedName("biodata_sex")
	private String biodataSex;

	@SerializedName("biodata_image")
	private String biodataImage;

	@SerializedName("biodata_personal_web")
	private String biodataPersonalWeb;

	@SerializedName("biodata_address")
	private String biodataAddress;

	@SerializedName("id_biodata")
	private String idBiodata;

	@SerializedName("users")
	private String users;

	@SerializedName("biodata_user_id")
	private String biodataUserId;

	@SerializedName("biodata_hp_number")
	private String biodataHpNumber;

	@SerializedName("biodata_birthplace")
	private String biodataBirthplace;

	@SerializedName("biodata_study_program")
	private String biodataStudyProgram;

	@SerializedName("biodata_position")
	private String biodataPosition;

	@SerializedName("biodata_birthdate")
	private String biodataBirthdate;

	@SerializedName("biodata_ktp_number")
	private String biodataKtpNumber;

	@SerializedName("biodata_telephone_number")
	private String biodataTelephoneNumber;

	public String getBiodataCollege(){
		return biodataCollege;
	}

	public String getBiodataSex(){
		return biodataSex;
	}

	public String getBiodataImage(){
		return biodataImage;
	}

	public String getBiodataPersonalWeb(){
		return biodataPersonalWeb;
	}

	public String getBiodataAddress(){
		return biodataAddress;
	}

	public String getIdBiodata(){
		return idBiodata;
	}

	public String getUsers(){
		return users;
	}

	public String getBiodataUserId(){
		return biodataUserId;
	}

	public String getBiodataHpNumber(){
		return biodataHpNumber;
	}

	public String getBiodataBirthplace(){
		return biodataBirthplace;
	}

	public String getBiodataStudyProgram(){
		return biodataStudyProgram;
	}

	public String getBiodataPosition(){
		return biodataPosition;
	}

	public String getBiodataBirthdate(){
		return biodataBirthdate;
	}

	public String getBiodataKtpNumber(){
		return biodataKtpNumber;
	}

	public String getBiodataTelephoneNumber(){
		return biodataTelephoneNumber;
	}
}