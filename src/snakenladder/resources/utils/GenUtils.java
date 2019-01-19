/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder.resources.utils;

import java.io.FileReader;
import java.util.Random;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author bayasys
 */
public class GenUtils {

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        if (max < 0 || (min < 0 && r.nextInt((max - min) + 1) + min > 5)) {
            return -r.nextInt((max - min) + 1) + min;
        } else {
            return r.nextInt((max - min) + 1) + min;
        }
    }

    public static JSONObject readJSON(String name) {
        JSONObject obj = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            Object obj1 = parser.parse(new FileReader(GenUtils.class.getResource(name).toString().replace("file:", "")));
            obj = (JSONObject) obj1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj;
    }

}
