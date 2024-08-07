class Solution {
    boolean solution(String s) {
        
        int count_left = 0; // ( 개수
        int count_right = 0;  // ) 개수
        
        //  괄호 () 쌍이 올바르게 종료된 후 ')' 가 나오면 false 처리
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            
            // 첫 글자가 ')' 라면 false 처리
            if(arr[0] == ')')
                return false;
            
            // (, ) 각각의 개수 카운트
            if(arr[i] == '(')
                count_left++;
            else
                count_right++;
            
            // (, ) 각각의 개수가 같을 때, 다음 문자가 ')' 라면 false 처리
            if((count_left == count_right) && (i!= arr.length -1 ) && arr[i+1] == ')'){
                return false;
            }
            
        }
        
        // (, ) 쌍의 개수가 같지 않으면 false 처리
        if(count_left != count_right)
            return false;
        
        // 그 외의 경우에는 모두 true
        return true;
        
    }
}