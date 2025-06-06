class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k)return "0";
        Stack<Character>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&k>0&&st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        if(st.isEmpty())return "0";
        while(k>0){st.pop();k--;}
        if(st.isEmpty())return "0";
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        sb.append(st.pop());
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}