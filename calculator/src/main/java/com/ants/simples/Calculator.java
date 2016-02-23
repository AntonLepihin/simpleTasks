package com.ants.simples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 2/7/16.
 */
public class Calculator {

    public static String formula = "1+2*10+50-2*5*1*2*3";

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.calculate(formula);
    }

    private Integer calculate(String s) {

        List<Integer> ops = new ArrayList<>();
        List<String> plus = new ArrayList<>();

        String[] chislas = s.split("[[+][*][-]]");
        String[] znaks = s.split("[0-9]+");

        List<String> actions = new ArrayList<>();
        for(String i : znaks) {
            if (!i.isEmpty()) actions.add(i);
            System.out.println(i);
        }

        for(int i=0; i< chislas.length; i++) {
            String action = actions.get(i);
            Integer op = Integer.valueOf(chislas[i]);
            while(action.equals("*")) {
                i++;
                Integer op2 = Integer.valueOf(chislas[i]);
                op = op*op2;
                if (i == actions.size())
                    break;
                action = actions.get(i);
            }
            ops.add(op);

            if (i < actions.size())
                plus.add(action);
        }

        Integer sum = ops.get(0);
        for(int i = 1; i<ops.size(); i++) {
            String action = plus.get(i-1);
            Integer op = ops.get(i);
            if (action.equals("+")) sum += op;
            else if (action.equals("-")) sum -= op;
        }

        System.out.println("Сумма = "+sum);
        return sum;
    }
}
