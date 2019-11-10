package 笔试.小米;

import java.util.Stack;

public class Main1 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String solution(String input) {

        if(input.length()<=0)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int node = 0;
        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            if(temp == '(' || temp == ')'){
                node = 0;
                continue;
            } else if(temp == ',' && !stack.isEmpty()){
                node = 0;
                stringBuilder.append(stack.pop());
                continue;
            } else{
                node = node*10+(temp-'0');
            }

            if(i+1<input.length() && input.charAt(i+1)=='('){
                stack.push(node);
                continue;
            }

            if(i+1<input.length()&& input.charAt(i+1)==','){
                stringBuilder.append(node);
                continue;
            }

            if(i+1<input.length() &&  input.charAt(i+1)==')'){
                stringBuilder.append(node);
                continue;
            }
        }

        return stringBuilder.toString();

    }

    /******************************结束写代码******************************/


    public static void main(String[] args){

        String res;
        String _input = "1(2(3,4(,5)),6(7,))";

        res = solution(_input);
        System.out.println(res);
    }
}
