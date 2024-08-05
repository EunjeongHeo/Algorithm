import java.util.*;
    
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 필요한 일수를 계산한 배열 만들기
        Integer[] days = new Integer[progresses.length];
        for( int i = 0; i < progresses.length ; i++){
            days[i] = (int)Math.ceil((100 - (double)progresses[i]) / speeds[i]);
        }
        
        
        // 정답 구하기
        ArrayList<Integer> answer = new ArrayList<>();
        for( int i = 0; i < days.length ; i++){
            
            // 이미 배포한 기능이라면, 넘어감
            if(days[i]==null){
                continue;
            }
            
            // 마지막 기능인데 배포가 안 되어 있다면,
            // 또는 현재 검사중인 i번째 기능이 그 다음 기능보다 먼저 완료된다면, 기능 1개 배포 처리
            if (i == days.length-1 || days[i]<days[i+1]){
                answer.add(1);
                days[i] = null;
            }
            
            // 현재 검사중인 i번째 기능보다 그 다음 기능이 먼저 완료된다면, 일괄 배포 처리
            else{
                int count = 1;
                for( int j=i+1; j < days.length ; j++){
                    if(days[i]>=days[j]){
                        count++;
                        days[j] = null;
                    }
                    else{
                        break;
                    }
                }
                answer.add(count);
                days[i] = null;
            }
            
            
            
        }
        
        int[] answerArr = new int[answer.size()];
        for(int i = 0; i <answer.size(); i++){
            answerArr[i] = answer.get(i);
        }
        
        return answerArr;
    }
}