package 笔试.快手;

import java.util.*;

public class Main2 {

    private static final Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        TreeSet<String> result = new TreeSet<>();
        letterCombinations(s,result);


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(String temp :result){
            stringBuilder.append(temp);
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        System.out.print(stringBuilder.toString().replace(", ]","]"));
    }



    public static void letterCombinations(String digits, TreeSet<String> result) {
        if (digits.length() != 0)
            backtrack("", digits,result);
    }

    public static void backtrack(String combination, String next_digits, TreeSet<String> result) {
        if (next_digits.length() == 0) {
            result.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1),result);
            }
        }
    }



}


