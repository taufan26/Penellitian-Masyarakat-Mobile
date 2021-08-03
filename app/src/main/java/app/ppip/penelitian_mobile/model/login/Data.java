package app.ppip.penelitian_mobile.model.login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("user_role")
	private String userRole;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("user_nidn")
	private String userNidn;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_image")
	private String userImage;

	@SerializedName("user_name")
	private String userName;

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

	public void setUserRole(String userRole){
		this.userRole = userRole;
	}

	public String getUserRole(){
		return userRole;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserNidn(String userNidn){
		this.userNidn = userNidn;
	}

	public String getUserNidn(){
		return userNidn;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	public String getUserImage(){
		return userImage;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

}