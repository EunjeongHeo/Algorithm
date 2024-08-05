import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // 중복 제거
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i=1; i<arr.length; i++){
            if (arr[i-1] != arr[i]){
                list.add(arr[i]);
            }
        }
        
        // 리스트 -> 배열
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}