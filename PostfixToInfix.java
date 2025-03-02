class Solution {
    static String postToInfix(String exp) {
        // code here
        int n = exp.length();
        Stack<String> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                s.push(Character.toString(ch));
            } else {
                String s1 = s.pop();
                String s2 = s.pop();
                String str = "(" + s2 + ch + s1 + ")";
                s.push(str);
            }
        }
        return s.pop();
    }
}
