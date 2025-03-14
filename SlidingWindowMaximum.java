class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[]res=new int[n-k+1];
        int ind=0;
        // for(int i=0;i<(n-k+1);i++){
        //     int max=nums[i];
        //     for(int j=i;j<(i+k);j++){
        //         if(max<nums[j])max=nums[j];
        //     }
        //     res[ind++]=max;
        // }
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1)res[ind++]=nums[dq.peekFirst()];
        }
        return res;
    }
}