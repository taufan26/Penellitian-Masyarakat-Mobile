package app.ppip.penelitian_mobile.model.logbookPenelitian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TambahLogbookPenelitian {

    @Expose
    @SerializedName("usulan_id") private String usulan_id;

    @Expose
    @SerializedName("tanggal") private String tanggal;

    @Expose
    @SerializedName("presentase") private String presentase;

    @Expose
    @SerializedName("kegiatan") private String kegiatan;

    @Expose
    @SerializedName("create_at") private String create_at;

    @Expose
    @SerializedName("status") private Boolean status;

    @Expose
    @SerializedName("message") private String message;

    public String getUsulan_id() {
        return usulan_id;
    }

    public void setUsulan_id(String usulan_id) {
        this.usulan_id = usulan_id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPresentase() {
        return presentase;
    }

    public void setPresentase(String presentase) {
        this.presentase = presentase;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
