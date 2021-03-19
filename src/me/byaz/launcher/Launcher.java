package me.byaz.launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.byaz.launcher.scenes.subs.GeneralScene;
import me.byaz.launcher.scenes.subs.types.impl.AccountAddon;
import me.byaz.launcher.telegram.TelegramBot;
import me.byaz.launcher.utils.constant.LauncherConstant;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import sk.tomsik68.mclauncher.api.login.IProfile;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDProfileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Launcher extends Application {

    /* This is the instance of the class */

    private static Launcher instance = new Launcher();

    /* This is the stage of the fx application */

    private Stage stage = new Stage();

    /* This is the general scene */

    private GeneralScene scene = GeneralScene.getInstance();

    /* This is an array of the avaible profiles */

    private ArrayList<IProfile> profiles = new ArrayList<>();

    /* This is the active profile */

    private IProfile profile;

    /* This block loads the profiles  */

    {
        try {
            this.profiles.addAll(Arrays.asList(new YDProfileIO(new File(LauncherConstant.MINECRAFT_DIRECTORY.getName())).read()));
            this.profiles.forEach(iProfile -> System.out.println(iProfile.getDisplayName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scene.registerNodes();
    }

    /* This is the overridden method from Application */

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setScene(scene.getScene());
        this.stage.show();
        AccountAddon.getInstance().draw();
        AccountAddon.getInstance().drawProfile(1);
    }

    /* This is the main method */

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        TelegramBot bot = new TelegramBot();
        try {
            api.registerBot(bot);
        } catch (TelegramApiRequestException exc){
            exc.printStackTrace();
        }
        Application.launch(args);
    }

    /* This method loads a new scene */

    public void loadScene(Scene scene){
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.show();
    }

    /* This is the getter of the instance */

    public static Launcher getInstance() {
        return instance;
    }

    /* This is the getter of the general scene */

    public GeneralScene getScene() {
        return scene;
    }

    /* This is the getter of the profiles */

    public ArrayList<IProfile> getProfiles(){
        return this.profiles;
    }

    /* This is the getter of the profile */

    public IProfile getProfile() {
        return profile;
    }

    /* This is the setter of the profile */

    public void setProfile(IProfile profile) {
        this.profile = profile;
    }
}
