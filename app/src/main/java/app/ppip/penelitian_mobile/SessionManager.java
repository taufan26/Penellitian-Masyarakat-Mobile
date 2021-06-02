package app.ppip.penelitian_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import app.ppip.penelitian_mobile.model.login.Data;

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

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }



}
