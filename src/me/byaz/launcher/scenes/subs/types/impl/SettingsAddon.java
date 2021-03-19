package me.byaz.launcher.scenes.subs.types.impl;

import com.jfoenix.controls.JFXSlider;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import me.byaz.launcher.animations.subs.FadeAnimation;
import me.byaz.launcher.scenes.subs.GeneralScene;
import me.byaz.launcher.scenes.subs.types.AddonInterface;
import me.byaz.launcher.utils.ComputerUtils;

import java.util.Arrays;

public class SettingsAddon implements AddonInterface {

    /* This is the only instance of the addon */

    private static SettingsAddon instance = new SettingsAddon();

    /* These are the two containers */

    private Pane[] var0 = {
            new Pane(),
            new Pane()
    };

    /* These are the three decorations */

    private Separator[] var1 = {
            new Separator(),
            new Separator(),
            new Separator()
    };

    /* These are the labels in the left */

    private Label[] var2 = {
            new Label("Ram".toUpperCase()),
            new Label("Ram".toUpperCase()),
            new Label("Resolution".toUpperCase()),
            new Label("Cpu".toUpperCase()),
            new Label("Architecture".toUpperCase()),
            new Label("System".toUpperCase())
    };

    /* These are the labels on the bottom right */

    private Label[] var3 = {
            new Label(),
            new Label(),
            new Label()
    };

    /* This is the ram slider */

    private JFXSlider var4 = new JFXSlider(1, 8, 0.1);

    /* This is the width text field */

    private TextField var5 = new TextField();

    /* This is the height text field */

    private TextField var6 = new TextField();

    /* These are the check boxes for the launch option */

    private CheckBox[] var7 = {
            new CheckBox("Hide".toUpperCase()),
            new CheckBox("Show".toUpperCase()),
            new CheckBox("Minimize".toUpperCase())
    };

    /* This is the constructor */

    private SettingsAddon(){
        this.registerNodes(this);
    }

    /* This is the overridden method of that draws the nodes */

    @Override
    public void draw(){
        Pane pane = GeneralScene.getInstance().getPane();
        for(Node node : Arrays.asList(var0[0], var0[1], var3[0], var3[1], var3[2], var1[0],
                var1[1], var1[2], var2[1], var2[3], var2[4], var2[5], var4)){
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
        for(Node node : Arrays.asList(var0[0], var0[1], var3[0], var3[1], var3[2], var1[0],
                var1[1], var1[2], var2[1], var2[3], var2[4], var2[5], var4)){
            if(pane.getChildren().contains(node)){
                pane.getChildren().remove(node);
                double opacity = node.getOpacity();
                new FadeAnimation(node, 3500, true).start(0, opacity);
            }
        }
    }

    /* This method draws var0 */

    public void func_0(){
        Pane pane;
        for(int i = 0; i < 2; i++){
            pane = this.var0[i];
            if (i == 0) {
                pane.setLayoutY(150);
            } else {
                pane.setLayoutY(336);
            }
            pane.setOpacity(0.50);
            pane.setLayoutX(200);
            pane.setPrefWidth(417);
            pane.setPrefHeight(108);
            pane.setStyle("-fx-background-color: #1B1C35");
        }
    }

    /* This method draws var1 */

    public void func_1(){
        Separator separator;
        for(int i = 0; i < 3; i++){
            separator = this.var1[i];
            if(i < 2){
                if(i == 0){
                    separator.setLayoutY(181);
                } else {
                    separator.setLayoutY(370);
                }
                separator.setLayoutX(340);
                separator.setPrefWidth(6);
                separator.setPrefHeight(48);
                separator.setOrientation(Orientation.VERTICAL);
            } else {
                separator.setLayoutX(305);
                separator.setLayoutY(299);
                separator.setPrefHeight(Region.USE_COMPUTED_SIZE);
                separator.setPrefWidth(200);
            }
            separator.setOpacity(0.21);
        }
    }

    /* This method draws var2 */

    public void func_2(){
        Label label;
        for(int i = 0; i < 6; i++){
            label = this.var2[i];
            switch (i){
                case 1:
                    label.setLayoutY(200);
                    break;
                case 3:
                    label.setLayoutY(353);
                    break;
                case 4:
                    label.setLayoutY(385);
                    break;
                default:
                    label.setLayoutY(417);
                    break;
            }
            label.setLayoutX(222);
            label.setOpacity(0.35);
            label.setStyle("-fx-font-size: 12; -fx-font-family: Impact; -fx-text-fill: WHITE");
        }
    }

    /* This method draws var3 */

    public void func_3(){
        Label label;
        for(int i = 0; i < 3; i++){
            label = this.var3[i];
            switch (i){
                case 0:
                    label.setLayoutY(353);
                    label.setText("Intel".toUpperCase());
                    break;
                case 1:
                    label.setLayoutY(385);
                    label.setText(ComputerUtils.getArchitecture());
                    break;
                default:
                    label.setLayoutY(417);
                    label.setText("Wind".toUpperCase());
                    break;
            }
            label.setLayoutX(575);
            label.setOpacity(0.19);
            label.setAlignment(Pos.CENTER_RIGHT);
            label.setStyle("-fx-font-size: 12; -fx-font-family: Impact; -fx-text-fill: WHITE");
        }
    }

    /* This method draws var4 */

    public void func_4(){
        this.var4.setPrefWidth(170);
        this.var4.setPrefHeight(5);
        this.var4.setBlockIncrement(0.1);
        this.var4.setOrientation(Orientation.HORIZONTAL);
        this.var4.setMin(1);
        this.var4.setMax(8);
        this.var4.setOpacity(0.30);
        this.var4.setLayoutX(400);
        this.var4.setLayoutY(200);
    }

    /* This method is the getter of the instance */

    public static SettingsAddon getInstance() {
        return instance;
    }
}
