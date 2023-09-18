package org.sbt.bracketchecker.validation.impl;

import org.sbt.bracketchecker.validation.BracketValidator;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class BracketValidatorImpl implements BracketValidator {

    public boolean isTextValid(String text) {
        return areBracketsValid(text) && !isTextInsideBracketsValid(text);
    }

    public boolean areBracketsValid(String text) {
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

    public boolean isTextInsideBracketsValid(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingBracket(stack.pop(), c)) {
                    return false;
                }
            } else if (!stack.isEmpty()) {
                if (!Character.isWhitespace(c)) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingBracket(char openingBracket, char closingBracket) {
        return openingBracket == '(' && closingBracket == ')' ||
                openingBracket == '{' && closingBracket == '}' ||
                openingBracket == '[' && closingBracket == ']';
    }

}
