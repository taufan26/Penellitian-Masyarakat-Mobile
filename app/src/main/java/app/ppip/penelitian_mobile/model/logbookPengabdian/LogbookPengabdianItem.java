package app.ppip.penelitian_mobile.model.logbookPengabdian;

import com.google.gson.annotations.SerializedName;

public class LogbookPengabdianItem{

	@SerializedName("logbook_date")
	private String logbookDate;

	@SerializedName("logbook_pengabdian_id")
	private String logbookPengabdianId;

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

	@SerializedName("usulan_pengabdian_judul")
	private String usulanPengabdianJudul;

	public String getLogbookDate(){
		return logbookDate;
	}

	public String getLogbookPengabdianId(){
		return logbookPengabdianId;
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

	public String getUsulanPengabdianJudul(){
		return usulanPengabdianJudul;
	}
}