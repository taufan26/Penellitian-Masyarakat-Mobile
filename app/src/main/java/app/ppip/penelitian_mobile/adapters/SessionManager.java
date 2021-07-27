package app.ppip.penelitian_mobile.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import app.ppip.penelitian_mobile.model.biodata.DataBio;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import app.ppip.penelitian_mobile.model.keanggotaan.DataAnggota;
import app.ppip.penelitian_mobile.model.login.Data;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "user_id";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_NAME = "user_name";
    public static final String USER_ROLE = "user_role";
    public static final String USER_NIDN = "user_nidn";
    public static final String USER_IMAGE = "user_image";

    //Biodata
    public static final String ID_BIODATA = "id_biodata";
    public static final String USERS = "users";
    public static final String BOIDATA_USER_ID = "biodata_user_id";
    public static final String BOIDATA_SEX = "biodata_sex";
    public static final String BOIDATA_COLLEGE = "biodata_college";
    public static final String BOIDATA_STUDY_PROGRAM = "biodata_study_program";
    public static final String BOIDATA_POSITION = "biodata_position";
    public static final String BOIDATA_BIRTHPLACE = "biodata_birthplace";
    public static final String BOIDATA_BIRTHDATE = "biodata_birthdate";
    public static final String BOIDATA_KTP_NUMBER = "biodata_ktp_number";
    public static final String BOIDATA_HP_NUMBER = "biodata_hp_number";
    public static final String BOIDATA_TELEPHONE_NUMBER = "biodata_telephone_number";
    public static final String BOIDATA_ADDRESS = "biodata_address";
    public static final String BOIDATA_PERSONAL_WEB = "biodata_personal_web";
    public static final String BOIDATA_IMAGE = "biodata_image";

    //Anggota
    public static final String ANGGOTA_ID = "anggota_penelitian_id ";
    public static final String ANGGOTA_USER_ID = "anggota_penelitian_user_id";
    public static final String ANGGOTA_ID_ID = "anggota_penelitian_penelitian_id";
    public static final String ANGGOTA_ROLE = "anggota_penelitian_role";
    public static final String ANGGOTA_TUGAS = "anggota_penelitian_tugas";
    public static final String ANGGOTA_CREATE = "created_at";
    public static final String ANGGOTA_UPDATE = "updated_at";

    //feature
    public static final String UNLOCK_FEATURE_ID = "unlock_feature_id ";
    public static final String UNLOCK_FEATURE_NAME = "unlock_feature_name";
    public static final String UNLOCK_FEATURE_START_YEAR = "unlock_feature_start_year";
    public static final String UNLOCK_FEATURE_END_YEAR = "unlock_feature_end_year";
    public static final String UNLOCK_FEATURE_START_TIME = "unlock_feature_start_time";
    public static final String UNLOCK_FEATURE_END_TIME = "unlock_feature_end_time";
    public static final String UNLOCK_FEATURE_CREATE_AT = "created_at";
    public static final String UNLOCK_FEATURE_UPDATE_AT = "updated_at";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(Data user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getUserId());
        editor.putString(USER_EMAIL, user.getUserEmail());
        editor.putString(USER_NAME, user.getUserName());
        editor.putString(USER_ROLE, user.getUserRole());
        editor.putString(USER_NIDN, user.getUserNidn());
        editor.putString(USER_IMAGE, user.getUserImage());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID,null));
        user.put(USER_EMAIL, sharedPreferences.getString(USER_EMAIL,null));
        user.put(USER_NAME, sharedPreferences.getString(USER_NAME,null));
        user.put(USER_ROLE, sharedPreferences.getString(USER_ROLE,null));
        user.put(USER_NIDN, sharedPreferences.getString(USER_NIDN,null));
        user.put(USER_IMAGE, sharedPreferences.getString(USER_IMAGE,null));
        return user;
    }

    //BIODATA SESSISON

    public void createBiodataList(DataBio user){
        editor.putString(ID_BIODATA, user.getIdBiodata());
        editor.putString(USERS, user.getUsers());
        editor.putString(BOIDATA_USER_ID, user.getBiodataUserId());
        editor.putString(BOIDATA_SEX, user.getBiodataSex());
        editor.putString(BOIDATA_COLLEGE, user.getBiodataCollege());
        editor.putString(BOIDATA_STUDY_PROGRAM, user.getBiodataStudyProgram());
        editor.putString(BOIDATA_POSITION, user.getBiodataPosition());
        editor.putString(BOIDATA_BIRTHPLACE, user.getBiodataBirthplace());
        editor.putString(BOIDATA_BIRTHDATE, user.getBiodataBirthdate());
        editor.putString(BOIDATA_KTP_NUMBER, user.getBiodataKtpNumber());
        editor.putString(BOIDATA_HP_NUMBER, user.getBiodataHpNumber());
        editor.putString(BOIDATA_TELEPHONE_NUMBER, user.getBiodataTelephoneNumber());
        editor.putString(BOIDATA_ADDRESS, user.getBiodataAddress());
        editor.putString(BOIDATA_PERSONAL_WEB, user.getBiodataPersonalWeb());
        editor.putString(BOIDATA_IMAGE, user.getBiodataImage());
        editor.commit();
    }

    public HashMap<String,String> getBiodataDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_BIODATA, sharedPreferences.getString(ID_BIODATA,null));
        user.put(USERS, sharedPreferences.getString(USERS,null));
        user.put(BOIDATA_USER_ID, sharedPreferences.getString(BOIDATA_USER_ID,null));
        user.put(BOIDATA_SEX, sharedPreferences.getString(BOIDATA_SEX,null));
        user.put(BOIDATA_COLLEGE, sharedPreferences.getString(BOIDATA_COLLEGE,null));
        user.put(BOIDATA_STUDY_PROGRAM, sharedPreferences.getString(BOIDATA_STUDY_PROGRAM,null));
        user.put(BOIDATA_POSITION, sharedPreferences.getString(BOIDATA_POSITION,null));
        user.put(BOIDATA_BIRTHPLACE, sharedPreferences.getString(BOIDATA_BIRTHPLACE,null));
        user.put(BOIDATA_BIRTHDATE, sharedPreferences.getString(BOIDATA_BIRTHDATE,null));
        user.put(BOIDATA_KTP_NUMBER, sharedPreferences.getString(BOIDATA_KTP_NUMBER,null));
        user.put(BOIDATA_HP_NUMBER, sharedPreferences.getString(BOIDATA_HP_NUMBER,null));
        user.put(BOIDATA_TELEPHONE_NUMBER, sharedPreferences.getString(BOIDATA_TELEPHONE_NUMBER,null));
        user.put(BOIDATA_ADDRESS, sharedPreferences.getString(BOIDATA_ADDRESS,null));
        user.put(BOIDATA_PERSONAL_WEB, sharedPreferences.getString(BOIDATA_PERSONAL_WEB,null));
        user.put(BOIDATA_IMAGE, sharedPreferences.getString(BOIDATA_IMAGE,null));
        return user;
    }

    //ANGGOTA SESSISON

    public void createAnggotaSession(DataAnggota user){
        editor.putString(ANGGOTA_ID, user.getAnggotaPenelitianId());
        editor.putString(ANGGOTA_USER_ID, user.getAnggotaPenelitianUserId());
        editor.putString(ANGGOTA_ID_ID, user.getAnggotaPenelitianPenelitianId());
        editor.putString(ANGGOTA_ROLE, user.getAnggotaPenelitianRole());
        editor.putString(ANGGOTA_TUGAS, user.getAnggotaPenelitianTugas());
        editor.putString(ANGGOTA_CREATE, user.getCreatedAt());
        editor.putString(ANGGOTA_UPDATE, user.getUpdatedAt());
        editor.commit();
    }

    public HashMap<String,String> getAnggotaDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ANGGOTA_ID, sharedPreferences.getString(ANGGOTA_ID,null));
        user.put(ANGGOTA_USER_ID, sharedPreferences.getString(ANGGOTA_USER_ID,null));
        user.put(ANGGOTA_ID_ID, sharedPreferences.getString(ANGGOTA_ID_ID,null));
        user.put(ANGGOTA_ROLE, sharedPreferences.getString(ANGGOTA_ROLE,null));
        user.put(ANGGOTA_TUGAS, sharedPreferences.getString(ANGGOTA_TUGAS,null));
        user.put(ANGGOTA_CREATE, sharedPreferences.getString(ANGGOTA_CREATE,null));
        return user;
    }

    //USULAN PENGABDIAN

    public void createFeatureSession(FeatureItem feature){
        editor.putString(UNLOCK_FEATURE_ID, feature.getUnlockFeatureId());
        editor.putString(UNLOCK_FEATURE_NAME, feature.getUnlockFeatureName());
        editor.putString(UNLOCK_FEATURE_START_YEAR, feature.getUnlockFeatureStartYear());
        editor.putString(UNLOCK_FEATURE_END_YEAR, feature.getUnlockFeatureEndYear());
        editor.putString(UNLOCK_FEATURE_START_TIME, feature.getUnlockFeatureStartTime());
        editor.putString(UNLOCK_FEATURE_END_TIME, feature.getUnlockFeatureEndTime());
        editor.putString(UNLOCK_FEATURE_CREATE_AT, feature.getCreatedAt());
        editor.putString(UNLOCK_FEATURE_UPDATE_AT, feature.getUpdatedAt());
        editor.commit();
    }

    public HashMap<String,String> getFeatureDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(UNLOCK_FEATURE_ID, sharedPreferences.getString(UNLOCK_FEATURE_ID,null));
        user.put(UNLOCK_FEATURE_NAME, sharedPreferences.getString(UNLOCK_FEATURE_NAME,null));
        user.put(UNLOCK_FEATURE_START_YEAR, sharedPreferences.getString(UNLOCK_FEATURE_START_YEAR,null));
        user.put(UNLOCK_FEATURE_END_YEAR, sharedPreferences.getString(UNLOCK_FEATURE_END_YEAR,null));
        user.put(UNLOCK_FEATURE_START_TIME, sharedPreferences.getString(UNLOCK_FEATURE_START_TIME,null));
        user.put(UNLOCK_FEATURE_END_TIME, sharedPreferences.getString(UNLOCK_FEATURE_END_TIME,null));
        user.put(UNLOCK_FEATURE_CREATE_AT, sharedPreferences.getString(UNLOCK_FEATURE_CREATE_AT,null));
        user.put(UNLOCK_FEATURE_UPDATE_AT, sharedPreferences.getString(UNLOCK_FEATURE_UPDATE_AT,null));
        return user;
    }





    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }



}
