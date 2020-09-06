package 笔试.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack stack = new Stack();
        List<Integer> list = new ArrayList();

        for(int i=0;i<expr.length();i++){
            char c = expr.charAt(i);
            if(c == '(' ){
                stack.push(c);
                list.add(i);
            }

            if(c==')'){
                if(stack.isEmpty())
                    return "";
                stack.pop();
                int index = list.remove(list.size()-1);
                expr = reverse(expr,index+1,i-1);
            }
        }

        if(!stack.isEmpty())
            return "";
        expr = expr.replaceAll("\\(","");
        expr = expr.replaceAll("\\)","");
        return expr;
    }

    static String reverse(String s, int start, int end){
        if(start>=end)
            return s;

        for(int i=start,j=end;i<j;i++,j--){
            s = s.substring(0,i)+s.charAt(j)+s.substring(i+1,j)+s.charAt(i)+s.substring(j+1,s.length());
        }
        return s;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res = "((ur)oi)";



        res = resolve(res);
        System.out.println(res);
    }
}
