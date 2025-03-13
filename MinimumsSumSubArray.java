class Solution {
    public static int[] findPrefix(int arr[]){
        int p[]=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            p[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return p;
    }
    public static int[] findSuffix(int arr[]){
        int p[]=new int[arr.length];
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            p[i]=st.isEmpty()?n-i:st.peek()-i;
            st.push(i);
        }
        return p;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long sum=0;
        int modulo=1_000_000_007;
        int prefix[]=findPrefix(arr);
        int suffix[]=findSuffix(arr);
        for(int i=0;i<n;i++){
            sum=((sum+(long)prefix[i]*suffix[i]*arr[i])%modulo)%modulo;
        }
        return (int)sum;
    }
}