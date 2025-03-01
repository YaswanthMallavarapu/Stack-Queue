import java.util.Stack;

public class InfixToPostfix {
    public static int precedence(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return 0;
    }

    public static String infixtopostfix(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(str.charAt(i)) <= precedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        // a+b -> ab+
        // a+b*c -> abc*+
        System.out.println(infixtopostfix("a+b*c"));
    }
}
