package app.ppip.penelitian_mobile.model.keanggotaan;

import com.google.gson.annotations.SerializedName;

public class DataAnggota {

	@SerializedName("anggota_penelitian_id")
	private String anggotaPenelitianId;

	@SerializedName("anggota_penelitian_role")
	private String anggotaPenelitianRole;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("anggota_penelitian_user_id")
	private String anggotaPenelitianUserId;

	@SerializedName("anggota_penelitian_penelitian_id")
	private String anggotaPenelitianPenelitianId;

	@SerializedName("anggota_penelitian_tugas")
	private String anggotaPenelitianTugas;

	@SerializedName("created_at")
	private String createdAt;

	public void setAnggotaPenelitianId(String anggotaPenelitianId){
		this.anggotaPenelitianId = anggotaPenelitianId;
	}

	public String getAnggotaPenelitianId(){
		return anggotaPenelitianId;
	}

	public void setAnggotaPenelitianRole(String anggotaPenelitianRole){
		this.anggotaPenelitianRole = anggotaPenelitianRole;
	}

	public String getAnggotaPenelitianRole(){
		return anggotaPenelitianRole;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setAnggotaPenelitianUserId(String anggotaPenelitianUserId){
		this.anggotaPenelitianUserId = anggotaPenelitianUserId;
	}

	public String getAnggotaPenelitianUserId(){
		return anggotaPenelitianUserId;
	}

	public void setAnggotaPenelitianPenelitianId(String anggotaPenelitianPenelitianId){
		this.anggotaPenelitianPenelitianId = anggotaPenelitianPenelitianId;
	}

	public String getAnggotaPenelitianPenelitianId(){
		return anggotaPenelitianPenelitianId;
	}

	public void setAnggotaPenelitianTugas(String anggotaPenelitianTugas){
		this.anggotaPenelitianTugas = anggotaPenelitianTugas;
	}

	public String getAnggotaPenelitianTugas(){
		return anggotaPenelitianTugas;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}
}