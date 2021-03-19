package me.byaz.launcher.scenes.subs.types.impl;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import me.byaz.launcher.animations.subs.FadeAnimation;
import me.byaz.launcher.scenes.subs.GeneralScene;
import me.byaz.launcher.scenes.subs.types.AddonInterface;
import me.byaz.launcher.utils.ImageUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LogsAddon implements AddonInterface {

    /* This is the only instance of the addon */

    private static LogsAddon instance = new LogsAddon();

    /* This is the background of the logs label */

    private Pane var0 = new Pane();

    /* This is the date of the logs */

    private Label var1 = new Label();

    /* This is the content of the logs pane */

    private Label var2 = new Label();

    /* This is the name of the player who wrote the log */

    private Label var3 = new Label("simoespo20".toUpperCase());

    /* This is the separator between the owner information and the logs pane */

    private Separator var4 = new Separator();

    /* This is the separator between the date and the logs pane */

    private Separator var5 = new Separator();

    /* This is the head of the owner */

    private ImageView var6 = new ImageView(ImageUtils.getFace("simoespo20").getImage());

    /* This is the calendar image */

    private ImageView var7 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/calendar.png"));

    /* This is the constructor */

    private LogsAddon(){
        this.registerNodes(this);
    }

    /* This is the overridden method of that draws the nodes */

    @Override
    public void draw(){
        Pane pane = GeneralScene.getInstance().getPane();
        for(Node node : Arrays.asList(var0, var1, var2, var3, var4, var5, var6, var7)){
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
        for(Node node : Arrays.asList(var0, var1, var2, var3, var4, var5, var6, var7)){
            if(pane.getChildren().contains(node)){
                FadeAnimation animation = new FadeAnimation(node, 1000, true);
                animation.start(0.44, 0);
                animation.setFinish(event -> pane.getChildren().remove(node));
            }
        }
    }

    /* This method draws var0 */

    public void func_0(){
        this.var0.setPrefWidth(417);
        this.var0.setPrefHeight(320);
        this.var0.setLayoutX(205);
        this.var0.setLayoutY(175);
        this.var0.setOpacity(0.44);
        this.var0.setStyle("-fx-background-color:  #1B1C35");
    }

    /* This method draws var1 */

    public void func_1(){
        this.var1.setOpacity(0.28);
        this.var1.setText(new SimpleDateFormat("dd/MM/yyy").format(new Date()));
        this.var1.setLayoutX(493);
        this.var1.setLayoutY(115);
        this.var1.setStyle("-fx-font-size: 17; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var2 */

    public void func_2(){
        this.var2.setLayoutX(230);
        this.var2.setLayoutY(196);
        this.var2.setOpacity(0.44);
        this.var2.setPrefHeight(275);
        this.var2.setPrefWidth(365);
        this.var2.setText("Ciao, \nquesta è una preview dei log che gli staffer potranno aggiornare per \nmezzo di Telegram o altri social. " +
                "Questo launcher è un programma \ncreato principalmente per far risparmiare tempo a chiunque giochi \nnel mondo del pvp e per chi non voglia " +
                "dover scaricare mod e \nversioni varie ogni volta. Per iniziare, seleziona una versione e clicca \nsul pulsante a destra. Più avanti verranno opzioni come " +
                "la \npossibilità di connettersi direttamente a un server dal launcher. \n\nSe aveste problemi con il launcher, \nvi prego di contattarmi via telegram" +
                "o github, mi piacerebbe poter \nsistemare il launcher e renderlo piacevole da usare per tutti. Se ci \nfossero persone interessate" +
                "a collaborare, vi prego di contattarmi in \nprivata, mi piacerebbe fare esperienza con altri. \n\nByaz");
        this.var2.setAlignment(Pos.TOP_LEFT);
        this.var2.setTextFill(Paint.valueOf("#ffffff"));
    }

    /* This method draws var3 */

    public void func_3(){
        this.var3.setPrefWidth(100);
        this.var3.setPrefHeight(22);
        this.var3.setLayoutX(270);
        this.var3.setLayoutY(115);
        this.var3.setOpacity(0.55);
        this.var3.setStyle("-fx-font-size: 17; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var4 */

    public void func_4(){
        this.var4.setOpacity(0.2);
        this.var4.setLayoutX(210);
        this.var4.setLayoutY(150);
        this.var4.setPrefWidth(175);
        this.var4.setPrefHeight(4);
    }

    /* This method draws var5 */

    public void func_5(){
        this.var5.setOpacity(0.2);
        this.var5.setLayoutY(150);
        this.var5.setLayoutX(475);
        this.var5.setPrefWidth(145);
        this.var5.setPrefHeight(4);
    }

    /* This method draws var6 */

    public void func_6(){
        this.var6.setFitWidth(41);
        this.var6.setFitHeight(40);
        this.var6.setLayoutX((210));
        this.var6.setLayoutY(99);
        this.var6.setOpacity(0.65);
    }

    /* This method draws var7 */

    public void func_7(){
        this.var7.setLayoutX(585);
        this.var7.setLayoutY(103);
    }

    /* This is the getter of the instance */

    public static LogsAddon getInstance() {
        return instance;
    }
}
