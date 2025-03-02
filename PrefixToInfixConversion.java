// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        int n = pre_exp.length();
        Stack<String> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(Character.toString(ch));
            } else {
                String s1 = st.pop();
                String s2 = st.pop();
                String str = "(" + s1 + ch + s2 + ")";
                st.push(str);
            }
        }
        return st.pop();
    }
}
