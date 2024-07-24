import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1 = {1,2,3,4,5}; // 1번 수포자의 반복패턴
        int[] pattern2 = {2,1,2,3,2,4,2,5}; // 2번 수포자의 반복패턴
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5,}; // 3번 수포자의 반복패턴
        
        // 1번 수포자
        int score1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
        }
        
        // 2번 수포자
        int score2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
        }
        
        // 3번 수포자
        int score3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }


        
        
        
        // 결과 계산
        int maxScore = Math.max(score1,Math.max(score2,score3));
        ArrayList<Integer> result = new ArrayList<>();
        if(score1 == maxScore){
            result.add(1);
        }
        if(score2 == maxScore){
            result.add(2);
        }
        if(score3 == maxScore){
            result.add(3);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
