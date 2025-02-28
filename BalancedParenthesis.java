class Solution {
    public boolean check(char ch,char popped){
        switch(ch){
            case ')': return popped=='(';
            case ']': return popped=='[';
            case '}': return popped=='{';
        }
        return false;
    }
    
    public boolean isValid(String s) {
       int n=s.length();
       Stack<Character>st=new Stack<>();
       for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        
        if(ch=='('||ch=='{'||ch=='['){
           st.push(ch);
        }
        else{
            if(st.isEmpty())return false;
            char popped=st.pop();
            if(!check(ch,popped)){
                return false;
            }
        }
       }
       return st.isEmpty();
    }
}