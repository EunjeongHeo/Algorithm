import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int num : scoville){
            q.add(num);
        }
        
        int answer = 0;

        while(q.peek() < K){
            if(q.size() < 2){
                return -1;
            }
            int a = q.remove();
            int b = q.remove();
            q.add(a+b*2);
            answer++;
        }
        
        return answer;
    }
}