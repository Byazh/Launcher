package me.byaz.launcher.utils;

import me.byaz.launcher.Launcher;
import me.byaz.launcher.utils.constant.LauncherConstant;
import me.byaz.launcher.utils.json.JSONParser;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import sk.tomsik68.mclauncher.api.login.IProfile;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class MojangUtils {

    /* This method returns the name of the player with a given uuid */

    public static String getName(String uuid) {
        try {
            @SuppressWarnings("deprecation")
            String nameJson = readJSON(uuid, false);
            JSONArray nameValue = (JSONArray) JSONValue.parseWithException(nameJson);
            String playerSlot = nameValue.get(nameValue.size() - 1).toString();
            JSONObject nameObject = (JSONObject) JSONValue.parseWithException(playerSlot);
            return nameObject.get("name").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    /* This method returns the uuid of the player with a given name */

    public static String getUnique(String name) {
        String url = "https://api.mojang.com/users/profiles/minecraft/"+name;
        try {
            @SuppressWarnings("deprecation")
            String UUIDJson = readJSON(name, true);
            if(UUIDJson.isEmpty()) return "invalid name";
            JSONObject UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);
            return UUIDObject.get("id").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "error";
    }

    /* This method returns the content of the web page */

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /* This method returns the page's json */

    private static String readJSON(String string, boolean name){
        InputStream inputStream;
        BufferedReader reader;
        try {
            if(name){
                inputStream = new URL( "https://api.mojang.com/users/profiles/minecraft/" + string).openStream();
            } else {
                inputStream = new URL( "https://api.mojang.com/user/profiles/" + string.replace("-", "") + "/names").openStream();
            }
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            return readAll(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /* This method returns the selected profile */

    public static IProfile getSelected(){
        String uuid = new JSONParser(LauncherConstant.LAUNCHER_PROFILES.getName()).getJSON().get("selectedUser").toString().substring(12, 44);
        String name = MojangUtils.getName(uuid);
        for(IProfile profile : Launcher.getInstance().getProfiles()){
            if(profile.getDisplayName().equalsIgnoreCase(name)){
                return profile;
            }
        }
        throw new NullPointerException();
    }
}