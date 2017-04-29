package com.aldo.experiments;

import java.util.Stack;

public class Brackets {
    static String isBalanced(String s){
        char[] chars = s.toCharArray();
        Stack stack = new Stack();

        for(char c : chars){
            if(c=='(')
                stack.push(")");
            if(c=='{')
                stack.push("}");
            if(c=='[')
                stack.push("]");

            if(c==')')
                if(stack.isEmpty() || !stack.pop().equals(")"))
                    return "NO";

            if(c=='}')
                if(stack.isEmpty() || !stack.pop().equals("}"))
                    return "NO";

            if(c==']')
                if(stack.isEmpty() || !stack.pop().equals("]"))
                    return "NO";
        }

        return stack.isEmpty()?"YES":"NO";
    }
}
