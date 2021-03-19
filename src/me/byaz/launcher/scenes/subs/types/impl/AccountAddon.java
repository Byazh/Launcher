package me.byaz.launcher.scenes.subs.types.impl;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import me.byaz.launcher.Launcher;
import me.byaz.launcher.animations.subs.FadeAnimation;
import me.byaz.launcher.scenes.subs.GeneralScene;
import me.byaz.launcher.scenes.subs.types.AddonInterface;
import me.byaz.launcher.utils.ImageUtils;
import me.byaz.launcher.utils.MojangUtils;
import sk.tomsik68.mclauncher.api.login.IProfile;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountAddon implements AddonInterface {

    /* This is the only instance of the class */

    private static AccountAddon instance = new AccountAddon();

    /* This is the index of the current profile */

    private int number;

    /* This is the selected profile */

    private IProfile profile = MojangUtils.getSelected();

    /* This is the isometric head of the profile */

    private ImageView var0 = new ImageView();

    /* This is the name of the profile */

    private Label var1 = new Label();

    /* This is the uuid of the profile */

    private Label var2 = new Label();

    /* This is the separator between the uuid and the button */

    private Separator var3 = new Separator();

    /* This is the select button */

    private Button var4 = new Button("                  Select".toUpperCase());

    /* This is an array of the two arrows */

    private ImageView[] var5 = {
            new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/left.png")),
            new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/right.png"))
    };

    /* This is the crown that the selected account has */

    private ImageView var6 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/crown.png"));

    {
        Launcher.getInstance().setProfile(MojangUtils.getSelected());
    }

    /* This is the constructor */

    private AccountAddon(){
        this.registerNodes(this);
    }

    /* This is the overridden method of that draws the nodes */

    @Override
    public void draw(){
        Pane pane = GeneralScene.getInstance().getPane();
        for(Node node : Arrays.asList(var0, var1, var2, var3, var4, var5[0], var5[1], var6)){
            if(!pane.getChildren().contains(node)){
                pane.getChildren().add(node);
                double opacity = node.getOpacity();
                new FadeAnimation(node, 3500, false).start(0, opacity);
            }
        }
    }

    /* This is the overridden method of that deletes the nodes */

    @Override
    public void delete(){
        Pane pane = GeneralScene.getInstance().getPane();
    }

    /* This method draws var0 */

    public void func_0(){
        this.var0.setImage(ImageUtils.getHead(Launcher.getInstance().getProfile().getDisplayName()).getImage());
        this.var0.setFitWidth(150);
        this.var0.setFitHeight(150);
        this.var0.setLayoutX(321);
        this.var0.setLayoutY(144);
    }

    /* This method draws var1 */

    public void func_1(){
        this.var1.setPrefWidth(41);
        this.var1.setPrefHeight(27);
        this.var1.setLayoutX(376);
        this.var1.setLayoutY(312);
        this.var1.setOpacity(0.44);
        this.var1.setText(Launcher.getInstance().getProfile().getDisplayName());
        this.var1.setStyle("-fx-font-size: 21; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var2 */

    public void func_2(){
        this.var2.setLayoutX(294);
        this.var2.setLayoutY(352);
        this.var2.setOpacity(0.28);
        this.var2.setText("5926084d-8095-4071-8008-11ef362e2224");
        this.var2.setStyle("-fx-font-size: 12; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var3 */

    public void func_3(){
        this.var3.setOrientation(Orientation.HORIZONTAL);
        this.var3.setOpacity(0.21);
        this.var3.setPrefWidth(41);
        this.var3.setPrefHeight(4);
        this.var3.setLayoutX(376);
        this.var3.setLayoutY(401);
    }

    /* This method draws var4 */

    public void func_4(){
        this.var4.setPrefWidth(172);
        this.var4.setPrefHeight(55);
        this.var4.setLayoutX(310);
        this.var4.setLayoutY(449);
        this.var4.setStyle("-fx-background-color: #1B1C20; -fx-border-color:  #3bb85a; -fx-background-radius: 4; -fx-border-radius: 4; -fx-font-size: 16; -fx-font-family: Impact; -fx-text-fill: WHITE");
        this.var4.setAlignment(Pos.CENTER_LEFT);
    }

    /* This method draws var5 */

    public void func_5(){
       ImageView image;
       for(int i = 0; i < 2; i++){
           image = this.var5[i];
           if(i == 0){
               image.setLayoutX(180);
           } else {
               image.setLayoutX(594);
           }
           image.setFitWidth(32);
           image.setFitHeight(27);
           image.setLayoutY(285);
       }
    }

    /* This method draws var6 */

    public void func_6(){
        this.var6.setFitWidth(32);
        this.var6.setFitHeight(30);
        this.var6.setLayoutX(378);
        this.var6.setLayoutY(95);
        this.var6.setOpacity(0);
    }

    /* This method draws the new profile in the screen */

    public void drawProfile(int index){
        ArrayList<IProfile> profiles = Launcher.getInstance().getProfiles();
        profiles.forEach(iProfile -> System.out.println(iProfile.getDisplayName()));
        if(index >= 0 && index <= profiles.size()){
            IProfile profile = profiles.get(index);
            Pane pane = GeneralScene.getInstance().getPane();
            if(index == 0){
                pane.getChildren().remove(var5[0]);
            }
            if(index == profiles.size()){
                pane.getChildren().remove(var5[1]);
            }
            if(profile.getDisplayName().equalsIgnoreCase(Launcher.getInstance().getProfile().getDisplayName())){
                this.var6.setOpacity(0.45);
            }
            this.var0.setImage(ImageUtils.getHead(profile.getDisplayName()).getImage());
            this.var1.setText(profile.getDisplayName());
            this.var2.setText(MojangUtils.getUnique(profile.getDisplayName()));
        }
    }

    /* This is the getter of the instance */

    public static AccountAddon getInstance() {
        return instance;
    }
}
