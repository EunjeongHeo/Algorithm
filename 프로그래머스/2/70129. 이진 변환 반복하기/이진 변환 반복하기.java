class Solution {
    public int[] solution(String s) {
        
        int count_translate = 0;
        int count_zero = 0;

        while (!s.equals("1")) {
            
            int originalLength = s.length(); // 0 제거 전 문자열 길이
            s = s.replaceAll("0", "");
            int newLength = s.length(); // 0 제거 후 문자열 길이
            
            count_zero += originalLength - newLength; // 0의 개수
            
            s = Integer.toBinaryString(newLength); // 0 제거 후 문자열 길이를 2진수로 변환하여 다음 입력 값으로 저장
            
            count_translate ++;
        }
        
        int[] answer = new int[]{count_translate, count_zero};
        return answer;  
    }
}
