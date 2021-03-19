package me.byaz.launcher.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import me.byaz.launcher.utils.constant.LauncherConstant;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {

    /* This method returns the 2d face of the player with the given username */

    public static ImageView getFace(String username){
        ImageView imageView = new ImageView();
        try {
            URL url = new URL(LauncherConstant.SKIN_SITE.getName() + "avatar/" + username);
            BufferedImage image = ImageIO.read(url);
            imageView.setImage(SwingFXUtils.toFXImage(image, null));
        } catch (IOException exc){
            exc.printStackTrace();
        }
        return imageView;
    }

    /* This method returns the isometric head of the player with the given username */

    public static ImageView getHead(String username){
        ImageView imageView = new ImageView();
        try {
            URL url = new URL(LauncherConstant.SKIN_SITE.getName() + "head/256/" + username);
            BufferedImage image = ImageIO.read(url);
            imageView.setImage(SwingFXUtils.toFXImage(image, null));
        } catch (IOException exc){
            exc.printStackTrace();
        }
        return imageView;
    }
}
