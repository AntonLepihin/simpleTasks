package com.ants.simples;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by anton on 2/7/16.
 */
public class Selfout {

    public static void main(String[] args) {

        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            String dir = s+"/calculator/src/main/java/com/ants/simples/";
            BufferedReader br = new BufferedReader(new FileReader(dir+"/Selfout.java"));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            Thread.sleep(100);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
