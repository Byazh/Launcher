package me.byaz.launcher.animations.subs;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;
import me.byaz.launcher.animations.AnimationInterface;

import java.util.ArrayList;

public class FadeAnimation implements AnimationInterface {

    /* This is the node we're working with */

    private Node node;

    /* This is the transition */

    private FadeTransition transition;

    /* This is the duration of the transition */

    private long duration;

    /* This is the boolean that specifies if the fade transition is in or out */

    private boolean out;

    /* This is an arraylist of all the active transitions */

    private static ArrayList<FadeTransition> transitions = new ArrayList<>();

    /* This is the constructor of the class */

    public FadeAnimation(Node node, long duration, boolean out){
        this.node = node;
        this.duration = duration;
        this.transition = new FadeTransition(Duration.millis(duration), node);
        this.transition.setOnFinished(event -> transitions.remove(transition));
        transitions.add(this.transition);
    }

    /* This is the start method with no parameters, it goes from 0 to 1 or from 1 to 0 */

    @Override
    public void start(){
        if(out){
            this.transition.setFromValue(1);
            this.transition.setToValue(0);
        } else {
            this.transition.setFromValue(0);
            this.transition.setToValue(1);
        }
        this.transition.play();
    }

    /* This is the overloaded start method, parameters start and end are the values the animation starts and ends at */

    public void start(double start, double end){
        if(out){
            this.transition.setFromValue(end);
            this.transition.setToValue(start);
        } else {
            this.transition.setFromValue(start);
            this.transition.setToValue(end);
        }
        this.transition.play();
    }

    /* This is method removes all current animations */

    public static void removeTransitions(){
        for(FadeTransition transition : transitions){
            transition.stop();
            transitions.remove(transition);
        }
    }

    /* This is method sets the on finished event of an animation */

    public void setFinish(EventHandler<ActionEvent> action){
        this.transition.setOnFinished(event -> {
            action.handle(event);
            transitions.remove(this.transition);
        });
    }
}
