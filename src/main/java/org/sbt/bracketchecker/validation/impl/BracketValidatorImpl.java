package org.sbt.bracketchecker.validation.impl;

import org.sbt.bracketchecker.validation.BracketValidator;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class BracketValidatorImpl implements BracketValidator {

    public boolean isTextValid(String text) {
        if (text.isEmpty()) {
            return false;
        }

        String openingBrackets = "({[";
        String closingBrackets = ")}]";

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            int openingIndex = openingBrackets.indexOf(c);
            int closingIndex = closingBrackets.indexOf(c);

            if (openingIndex != -1) {
                stack.push(c);
            } else if (closingIndex != -1) {
                if (stack.isEmpty() || openingBrackets.indexOf(stack.pop()) != closingIndex) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
