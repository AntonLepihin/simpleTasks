package com.ants.simples;

/**
 * Created by anton on 2/7/16.
 */
public class StringRevertor {

    public static void main(String[] args) {
        String s = "1234567890000asdfghjklpoiuytrewq";
        String invert = invert(s);
        System.out.println(invert);
    }

    private static String invert(String s) {
        StringBuffer buf = new StringBuffer();
        for(int i=s.length()-1; i>=0; i--) {
            buf.append(s.charAt(i));
        }
        return buf.toString();
    }
}
