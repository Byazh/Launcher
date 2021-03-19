package me.byaz.launcher.animations.subs;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import me.byaz.launcher.animations.AnimationInterface;

import java.util.TimerTask;

public class ColorAnimation extends TimerTask implements AnimationInterface {

    /* This is the pane we are working with */

    private Region region;

    /* These are the three animations */

    private JFXFillTransition first;
    private JFXFillTransition second;
    private JFXFillTransition third;

    /* This is the class' constructor, it registers the animations and the region and it starts the animation */

    public ColorAnimation(Region region){
        this.region = region;
        this.first = new JFXFillTransition(Duration.millis(7000), this.region, Color.BLUE, Color.LIGHTBLUE);
        this.second = new JFXFillTransition(Duration.millis(7000), this.region, Color.LIGHTBLUE, Color.DARKCYAN);
        this.third = new JFXFillTransition(Duration.millis(7000), this.region, Color.DARKCYAN, Color.BLUE);
        this.start();
    }

    /* This is the overridden method that registers the on finished events */

    @Override
    public void run() {
        this.first.setOnFinished(event -> this.second.play());
        this.second.setOnFinished(event ->  this.third.play());
        this.third.setOnFinished(event ->  this.first.play());
    }

    /* This is the overridden method that starts the animation */

    @Override
    public void start() {
        this.first.play();
    }
}
