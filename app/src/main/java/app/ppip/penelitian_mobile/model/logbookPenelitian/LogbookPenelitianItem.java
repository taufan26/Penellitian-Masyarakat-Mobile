package app.ppip.penelitian_mobile.model.logbookPenelitian;

import com.google.gson.annotations.SerializedName;

public class LogbookPenelitianItem{

	@SerializedName("logbook_date")
	private String logbookDate;

	@SerializedName("logbook_penelitian_id")
	private String logbookPenelitianId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("logbook_id")
	private String logbookId;

	@SerializedName("logbook_uraian_kegiatan")
	private String logbookUraianKegiatan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("logbook_presentase")
	private String logbookPresentase;

	@SerializedName("usulan_penelitian_judul")
	private String usulanPenelitianJudul;

	public String getLogbookDate(){
		return logbookDate;
	}

	public String getLogbookPenelitianId(){
		return logbookPenelitianId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getLogbookId(){
		return logbookId;
	}

	public String getLogbookUraianKegiatan(){
		return logbookUraianKegiatan;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLogbookPresentase(){
		return logbookPresentase;
	}

	public String getUsulanPenelitianJudul(){
		return usulanPenelitianJudul;
	}

}