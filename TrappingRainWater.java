class Solution {
    public int trap(int[] height) {
        int n=height.length;
        // int leftmax[]=new int[n];
        // leftmax[0]=height[0];
        // int rightmax[]=new int[n];
        // rightmax[n-1]=height[n-1];
        // for(int i=1;i<n;i++){
        //     leftmax[i]=Math.max(leftmax[i-1],height[i]);
        // }
        // for(int i=n-2;i>=0;i--){
        //     rightmax[i]=Math.max(rightmax[i+1],height[i]);
        // }
        // int total=0;
        // for(int i=0;i<n;i++){
        //     if(height[i]<leftmax[i]&&height[i]<rightmax[i]){
        //         total+=Math.min(leftmax[i],rightmax[i])-height[i];
        //     }
        // }
        int left=0,right=n-1;
        int total=0,leftmax=height[0],rightmax=height[n-1];
        while(left<right){
            if(leftmax<=rightmax){
                left++;
                if(leftmax>height[left]){
                    total+=leftmax-height[left];
                }
                else{
                    leftmax=height[left];
                }
                
            }
            else{
                right--;
                if(rightmax>height[right]){
                    total+=rightmax-height[right];
                }
                else{
                    rightmax=height[right];
                }

            }
        }
        return total;
    }
}