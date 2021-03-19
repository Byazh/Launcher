package me.byaz.launcher.utils.constant;

public enum LauncherConstant {

    MINECRAFT_DIRECTORY("C:\\Users\\famiglia sottero\\AppData\\Roaming\\.minecraft"),
    LAUNCHER_PROFILES("C:\\Users\\famiglia sottero\\AppData\\Roaming\\.minecraft\\launcher_profiles.json"),
    SKIN_SITE("https://minepic.org/");

    String string;

    LauncherConstant(String string){
        this.string = string;
    }

    public String getName(){
        return this.string;
    }
}
