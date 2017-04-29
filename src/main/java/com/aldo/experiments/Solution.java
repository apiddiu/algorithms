package com.aldo.experiments;

import java.util.Stack;

public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int hasBalancedBrackets(String str)
    {
        Stack<String> stack = new Stack();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c=='(')
                stack.push(")");
            if(c=='{')
                stack.push("}");
            if(c=='[')
                stack.push("]");

            if(c==')')
                if(stack.isEmpty() || !stack.pop().equals(")"))
                    return 0;

            if(c=='}')
                if(stack.isEmpty() || !stack.pop().equals("}"))
                    return 0;

            if(c==']')
                if(stack.isEmpty() || !stack.pop().equals("]"))
                    return 0;
        }

        return stack.isEmpty()?1:0;
    }
    // METHOD SIGNATURE ENDS
}
