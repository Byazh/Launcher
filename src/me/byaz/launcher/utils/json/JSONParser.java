package me.byaz.launcher.utils.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class JSONParser {

    /* This is the content of the JSON */

    private String content;

    /* This is the directory of the JSON */

    private String directory;

    /* This is the constructor */

    public JSONParser(String directory){
        this.directory = directory;
    }

    /* This is the getter of the json */

    public JSONObject getJSON() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.directory));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            content = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(content);
    }
}
