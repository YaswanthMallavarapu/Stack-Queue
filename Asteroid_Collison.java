class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
               stack.push(asteroids[i]);
            }
            else{
                while(!stack.isEmpty()&&stack.peek()>0&&Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()&&stack.peek()==Math.abs(asteroids[i]))stack.pop();
                else if(stack.isEmpty() || stack.peek()<0)stack.push(asteroids[i]);
            }
        }
       
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop(); 
        }
        return res;
    }
}