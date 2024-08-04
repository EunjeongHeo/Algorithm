class Solution {
    public int[] solution(int brown, int yellow) {
        
        int brownRow = 3; // 행 개수 (세로 길이)
        int brownCol = 3; // 열 개수 (가로 길이)
        int yellowRow = 1; // 행 개수 (세로 길이)
        int yellowCol = 1; // 열 개수 (가로 길이)
        
        for (int i = 1; i < yellow ; i++){
            
            // yellow 개수 고려 -> yellow 가로,세로 길이 세팅
            yellowRow = i;
            if (yellow%yellowRow == 0)
                yellowCol = yellow/yellowRow;
            
            // yellow의 가로,세로 길이 고려 -> brown 가로,세로 길이 세팅
            brownRow = yellowRow + 2;
            brownCol = yellowCol + 2;
            
            // 조건 필터
            if (brown == (brownRow * brownCol - yellowRow * yellowCol)) // 총 가로,세로 길이 고려 -> brown 개수 확인
                return new int[]{brownCol, brownRow};;
        }
        
        return new int[]{brownCol, brownRow};
    }
}