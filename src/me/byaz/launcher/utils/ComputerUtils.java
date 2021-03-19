package me.byaz.launcher.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComputerUtils {

    /* This method returns the system architecture */

    public static String getArchitecture(){
        String architecture = "x32";
        if(System.getProperty("os.name").contains("Windows")){
            if(System.getenv("ProgramFiles(x86)") != null){
                architecture = "x64";
            }
        } else if(System.getProperty("os.arch").indexOf(64) != -1){
            architecture = "x64";
        }
        return architecture;
    }

    /* This method returns the cpu name */

    public static String getProcessor() {
        ProcessThread thread = new ProcessThread();
        thread.start();
        return thread.getString();
    }

    /* This is an inner class, a thread that runs a command and gets the results of it */

    private static final class ProcessThread extends Thread {

        /* This is the string */

        private String name;

        /* This is the process */

        private Process process;

        /* This is the constructor */

        private ProcessThread(){
            try {
                this.process = Runtime.getRuntime().exec("cmd /c wmic cpu get name");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* This is the overridden method */

        @Override
        public void run(){
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                while((name = input.readLine()) != null) {
                    System.out.println(input.readLine());
                    this.name = input.readLine();
                }
            } catch (IOException exc){
                exc.printStackTrace();
            }
        }

        /* This is the getter of the string */

        String getString() {
            return this.name;
        }
    }
}
