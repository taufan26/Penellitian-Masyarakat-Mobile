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