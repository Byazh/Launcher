package me.byaz.launcher.scenes.subs;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import me.byaz.launcher.scenes.AbstractScene;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class GeneralScene extends AbstractScene {

    /* This is the only instance of general scene */

    private static GeneralScene instance = new GeneralScene();

    /* This is the exit image */

    private ImageView var0 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/exit.png"));

    /* This is the background of the logo at the top left of the screen */

    private Pane var1 = new Pane();

    /* This is the background of the sidebar */

    private Pane var2 = new Pane();

    /* This is the background of everything except the sidebar */

    private Pane var3 = new Pane();

    /* This is an array of separators, one for each image in the sidebar */

    private Separator[] var4 = {
            new Separator(),
            new Separator(),
            new Separator(),
            new Separator(),
            new Separator()
    };

    /* This is an array of some decorations around the screen */

    private Pane[] var5 = {
            new Pane(),
            new Pane(),
            new Pane()
    };

    /* This is the version selector box */

    private ChoiceBox<String> var6 = new ChoiceBox<>();

    /* This is the label next to the version selector */

    private Label var7 = new Label("Versions".toUpperCase());

    /* This is the vertical separator in the middle of the screen */

    private Separator var8 = new Separator();

    /* This is the separator between the choice box and the version label */

    private Separator var9 = new Separator();

    /* This is the launch button */

    private Button var10 = new Button("Launch".toUpperCase());

    /* These are the two labels, help and terms */

    private Label var11 = new Label("Help".toUpperCase());
    private Label var12 = new Label("Terms".toUpperCase());

    /* This is the logo image */

    private ImageView var13 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/logo.png"));

    /* These are the images in the sidebar */

    private ImageView var14 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/internet.png"));
    private ImageView var15 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/settings.png"));
    private ImageView var16 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/user.png"));
    private ImageView var17 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/information.png"));
    private ImageView var18 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/shop.png"));

    /* This is the background image */

    private ImageView var19 = new ImageView(new Image("/me/byaz/launcher/scenes/subs/assets/background.png"));


    /* This is the constructor */

    private GeneralScene(){}

    /* This method registers the pane */

    private void drawPane(){
        this.pane.setPrefHeight(587);
        this.pane.setPrefWidth(1227);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                for(Node node : Arrays.asList(var19, var3, var10, var9, var10, var7, var9,
                        var6, var0, var8, var1, var2, var14, var11, var12, var14, var16,
                        var17, var18, var15, var5[j], var4[i], var13)){
                    if(!pane.getChildren().contains(node)){
                        this.pane.getChildren().add(node);
                    }
                }
            }
        }
    }

    /* This method draws var0 */

    private void func_0(){
        this.var0.setFitHeight(25);
        this.var0.setFitWidth(25);
        this.var0.setLayoutX(1195);
        this.var0.setLayoutY(10);
        this.var0.setOnMouseEntered(event -> var0.setOpacity(0.650));
        this.var0.setOnMouseExited(event -> var0.setOpacity(1.0));
        this.var0.setOnMouseClicked(event -> System.exit(0));
    }

    /* This method draws var1 */

    private void func_1(){
        this.var1.setPrefWidth(99);
        this.var1.setPrefHeight(102);
        this.var1.setStyle("-fx-background-color: #0082D1;");
    }

    /* This method draws var2 */

    private void func_2(){
        this.var2.setPrefHeight(499);
        this.var2.setPrefWidth(99);
        this.var2.setLayoutY(100);
        this.var2.setStyle("-fx-background-color: #1C1F23;");
    }

    /* This method draws var3 */

    private void func_3(){
        this.var3.setPrefHeight(599);
        this.var3.setPrefWidth(1131);
        this.var3.setLayoutY(0);
        this.var3.setLayoutX(99);
        this.var3.setOpacity(0.91);
        this.var3.setStyle("-fx-background-color: #1B1C20;");
    }

    /* This method draws var6 */

    private void func_6(){
        this.var6.setLayoutX(885);
        this.var6.setLayoutY(348);
        this.var6.setPrefHeight(25);
        this.var6.setPrefWidth(83);
        this.var6.setStyle("-fx-background-color: #1B1C35; -fx-font-size: 12; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var7 */

    private void func_7(){
        this.var7.setLayoutX(1000);
        this.var7.setLayoutY(350);
        this.var7.setOpacity(0.44);
        this.var7.setPrefHeight(17);
        this.var7.setPrefWidth(50);
        this.var7.setStyle("-fx-font-size: 12; -fx-font-family: Impact; -fx-text-fill: WHITE");
    }

    /* This method draws var8 */

    private void func_8(){
        this.var8.setPrefWidth(4);
        this.var8.setPrefHeight(420);
        this.var8.setLayoutX(685);
        this.var8.setLayoutY(95);
        this.var8.setOpacity(0.2);
        this.var8.setOrientation(Orientation.VERTICAL);
    }

    /* This method draws var9 */

    private void func_9(){
        this.var9.setLayoutX(980);
        this.var9.setLayoutY(336);
        this.var9.setPrefHeight(48);
        this.var9.setPrefWidth(4);
        this.var9.setOpacity(0.2);
        this.var9.setOrientation(Orientation.VERTICAL);
    }

    /* This method draws var10 */

    private void func_10(){
        this.var10.setLayoutX(865);
        this.var10.setLayoutY(255);
        this.var10.setPrefHeight(67);
        this.var10.setPrefWidth(225);
        this.var10.setStyle("-fx-background-color: #1B1C20; -fx-border-color: #94a8e0; -fx-background-radius: 4; -fx-border-radius: 4; -fx-font-size: 16; -fx-font-family: Impact; -fx-text-fill: WHITE");
        this.var10.setOnMouseEntered(event -> this.var10.setOpacity(0.65));
        this.var10.setOnMouseExited(event -> this.var10.setOpacity(1.00));
    }

    /* This method draws var11 */

    private void func_11(){
        this.var11.setLayoutX(22);
        this.var11.setLayoutY(565);
        this.var11.setPrefHeight(17);
        this.var11.setPrefWidth(55);
        this.var11.setTextFill(Paint.valueOf("#5e5d5d"));
        this.var11.setStyle("-fx-font-size: 13; -fx-font-family: Impact;");
    }

    /* This method draws var12 */

    private void func_12(){
        this.var12.setLayoutX(22);
        this.var12.setLayoutY(540);
        this.var12.setPrefHeight(17);
        this.var12.setPrefWidth(55);
        this.var12.setTextFill(Paint.valueOf("#5e5d5d"));
        this.var12.setStyle("-fx-font-size: 12; -fx-font-family: Impact;");
    }

    /* This method draws var13 */

    private void func_13(){
        this.var13.setFitHeight(65);
        this.var13.setFitWidth(55);
        this.var13.setLayoutX(22);
        this.var13.setLayoutY(18);
    }

    /* This method draws var14 */

    private void func_14(){
        this.var14.setLayoutX(33);
        this.var14.setLayoutY(125);
    }

    /* This method draws var15 */

    private void func_15(){
        this.var15.setLayoutX(33);
        this.var15.setLayoutY(203);
        this.var15.setOpacity(0.45);
    }

    /* This method draws var16 */

    private void func_16(){
        this.var16.setLayoutX(33);
        this.var16.setLayoutY(279);
        this.var16.setOpacity(0.45);
    }

    /* This method draws var17 */

    private void func_17(){
        this.var17.setLayoutX(33);
        this.var17.setLayoutY(360);
        this.var17.setOpacity(0.45);
    }

    /* This method draws var18 */

    private void func_18(){
        this.var18.setLayoutX(33);
        this.var18.setLayoutY(435);
        this.var18.setOpacity(0.45);
    }

    /* This method draws var19 */

    private void func_19(){
        this.var19.setFitHeight(702);
        this.var19.setFitWidth(1227);
        this.var19.setLayoutX(2);
        this.var19.setLayoutY(-103);
    }

    /* This method draws var4 */

    private void func_4(){
        Separator previous;
        Separator current;
        for(int i = 0; i < var4.length; i++){
            previous = i == 0 ? var4[0] : var4[i - 1];
            current = var4[i];
            switch (i){
                case 0:
                    current.setPrefWidth(23);
                    current.setLayoutY(180);
                    break;
                case 1:
                    current.setLayoutY(253);
                    current.setPrefWidth(previous.getPrefWidth() + 9);
                    break;
                case 2:
                    current.setLayoutY(332);
                    current.setPrefWidth(previous.getPrefWidth() + 9);
                    break;
                case 3:
                    current.setLayoutY(408);
                    current.setPrefWidth(previous.getPrefWidth() + 9);
                    break;
                default:
                    current.setLayoutY(483);
                    current.setPrefWidth(previous.getPrefWidth() + 9);
                    break;

            }
            current.setLayoutX(20);
            current.setOpacity(0.2);
            current.setPrefHeight(4);

        }
    }

    /* This method draws var5 */

    private void func_5(){
        for(int i = 0; i < 3; i++){
            Pane current = var5[i];
            switch (i){
                case 0:
                    current.setLayoutX(133);
                    current.setLayoutY(219);
                    current.setPrefHeight(163);
                    current.setPrefWidth(4);
                    break;
                case 1:
                    current.setLayoutX(730);
                    current.setLayoutY(23);
                    current.setPrefWidth(200);
                    current.setPrefHeight(4);
                    break;
                default:
                    current.setLayoutX(987);
                    current.setLayoutY(559);
                    current.setPrefWidth(200);
                    current.setPrefHeight(4);
                    break;
            }
            current.setStyle("-fx-background-color: #1373EF;");
        }
    }

    /* This is the overridden method that will register every node */

    @Override
    public void registerNodes() {
        Class reflection = this.getClass();
        for(Method method : reflection.getDeclaredMethods()){
            if(method.getName().startsWith("func") && !Arrays.asList("registerNodes").contains(method.getName())){
                try {
                    method.invoke(this);
                } catch (IllegalAccessException | InvocationTargetException exc){
                    exc.printStackTrace();
                }
            }
        }
        this.drawPane();
    }

    public static GeneralScene getInstance() {
        return instance;
    }
}

