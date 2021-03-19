package me.byaz.launcher.scenes.subs.types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface AddonInterface {

    /* This abstract method draws the additional nodes in the scene */

    void draw();

    /* This abstract method deletes the additional nodes from the scene */

    void delete();

    /* This default method registers the nodes in the class */

    default <T extends AddonInterface> void registerNodes(T parameter){
        Class reflection = parameter.getClass();
        for(Method method : reflection.getDeclaredMethods()){
            if(method.getName().startsWith("func") && !Arrays.asList("registerNodes").contains(method.getName())){
                try {
                    method.invoke(this);
                } catch (IllegalAccessException | InvocationTargetException exc){
                    exc.printStackTrace();
                }
            }
        }
    }
}
