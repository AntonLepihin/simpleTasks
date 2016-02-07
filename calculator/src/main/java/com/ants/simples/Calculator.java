package com.ants.simples;

import jdk.nashorn.internal.objects.annotations.Getter;
import sun.misc.FormattedFloatingDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by anton on 2/7/16.
 */
public class Calculator {

    public static String formula = "1+2*3+50-10*5";


    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.calculate(formula);
    }

    private Integer calculate(String s) {

        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> opers = new Stack<Character>();

        String[] chislas = s.split("[[+][*][-]]");
        String[] znaks = s.split("[0-9]+");

        Formula f = new Formula();
        for(String i : chislas) {
            f.getChisla().add(Integer.valueOf(i));
            //operands.push(Integer.valueOf(i));
            System.out.println(i);
        }
        for(String i : znaks) {
            if (!i.isEmpty()) f.getActions().add(i);
            //opers.push(i.charAt(0));
            System.out.println(i);
        }


        Formula fplus = f.calcul(f, "*");
        fplus = f.calcul(fplus, "+");
        fplus = f.calcul(fplus, "-");

        return 0;
    }


    private Integer calculate(Integer a, Integer b, String action) {
        switch (action) {
            case "*": return a*b;
            case "+": return a+b;
            case "-": return a-b;
        }
        return 0;
    }


    private class Formula {
        List<Integer> chisla = new ArrayList<Integer>();
        List<String> actions = new ArrayList<String>();

        public Formula() { }

        public List<Integer> getChisla() {
            return chisla;
        }

        public List<String> getActions() {
            return actions;
        }


        public Formula calcul(Formula f, String doaction) {
            Formula fplus = new Formula();

            Integer a = null;
            Integer b = null;
            boolean add = true;

            for(int i=0; i<f.getActions().size(); i++) {
                if (a == null)
                    a = Integer.valueOf(f.getChisla().get(i));

                b = Integer.valueOf(f.getChisla().get(i+1));

                String action = f.getActions().get(i);
                if (action.equals(doaction)) {
                    a = calculate(a, b, action);
                    fplus.getChisla().add(a);
                    add = false;
                } else {
                    if (add) fplus.getChisla().add(a);
                    fplus.getActions().add(action);
                    a = b;

                    if (i == f.getActions().size()-1 )
                        fplus.getChisla().add(b);
                    add = true;
                }
            }
            return fplus;
        }
    }
}
