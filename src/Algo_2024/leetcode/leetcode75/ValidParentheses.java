package Algo_2024.leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("){"));
  }

  private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
      ')', '(',
      ']', '[',
      '}', '{'
  );

  public static boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }

    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {
      if (BRACKET_PAIRS.containsValue(ch)) {
        stack.push(ch);
      } else if (stack.isEmpty() || stack.pop() != BRACKET_PAIRS.get(ch)) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public boolean isValidWithExtreme(String s) {
    if (s.length() % 2 != 0 || s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
      return false;
    }

    char[] stack = new char[s.length() / 2];
    int top = -1;

    for (char ch : s.toCharArray()) {
      switch (ch) {
        case '(':
        case '[':
        case '{':
          if (top + 1 < stack.length) {
            stack[++top] = ch;
          } else {
            return false;
          }
          break;
        case ')':
          if (top == -1 || stack[top--] != '(') {
            return false;
          }
          break;
        case ']':
          if (top == -1 || stack[top--] != '[') {
            return false;
          }
          break;
        case '}':
          if (top == -1 || stack[top--] != '{') {
            return false;
          }
          break;
      }
    }

    return top == -1;
  }
}
