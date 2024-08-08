import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        
        
        
        Queue<Integer> rq = new LinkedList<>(); // 우선순위 레디 큐
        int[] num = new int[10]; // 인덱스에 해당하는 우선순위의 개수를 담는 배열
        for( int p : priorities){
            rq.offer(p);
            num[p]++;
        }
        
        int count = 0; // 제거된 원소 개수 카운트
        
        do{
            boolean check = false; // 큐에 다시 삽입 되었는지 여부
            
            // 현재 원소보다 우선순위가 더 높은 게 있다면 큐에서 제거 후 다시 삽입
            for (int i = rq.peek() + 1 ; i < num.length; i++){
                if(num[i] > 0){ 
                    rq.offer(rq.poll());
                    check = true;
                    if(location == 0){
                        location = rq.size()-1;
                    }
                    else{
                        location--;
                    }
                    break;
                }
            }
            
            // 현재 원소가 우선순위가 가장 높은 것이라면 큐에서 제거
            if (check == false){
                num[rq.poll()]--;
                count++;
                if(location == 0){
                    return count;
                }else{
                    location--;
                }
                
            }
            
        }while(!rq.isEmpty()); // 큐가 비어있을 때까지 진행
        
        
        return -1;
    }
}