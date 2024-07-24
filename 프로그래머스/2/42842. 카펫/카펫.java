class Solution {
    public int[] solution(int brown, int yellow) {
        
        int yellow_col = 1; // 노란색 격자의 열의 개수 (가로 길이) - 최소값으로 초기화
        int yellow_row = 1; // 노란색 격자의 행의 개수 (세로 길이) - 최소값으로 초기화
        
        int brown_col = 3; // 갈색 격자의 열의 개수 (가로 길이) - 최소값으로 초기화
        int brown_row = 3; // 갈색 격자의 행의 개수 (세로 길이) - 최소값으로 초기화
        
        int[] answer = new int[]{brown_col, brown_row};
        
        for(int i = 1; i <= yellow ; i++){
            // 주어진 노란색 개수를 통해 노란색의 가로,세로 길이 임의 지정
            yellow_col = i;
            yellow_row = yellow / yellow_col;
            
            // 노란색의 가로, 세로 길이를 통해 갈색의 가로,세로 길이 임의 지정
            brown_col = yellow_col+2;
            brown_row = yellow_row+2;
            
            if (
                (brown+yellow) == (brown_col*brown_row) && // 전체 격자 개수 확인
                (brown_col*brown_row - yellow_col*yellow_row == brown) // 갈색 격자 개수 확인
            ){
                answer = new int[]{brown_col, brown_row};
            }
        }
    
        return answer;
        
    }
}