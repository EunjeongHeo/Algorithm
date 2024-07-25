import java.util.*;

class Solution {
    public long solution(String expression) {
        ArrayList<String> calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        long answer = Math.abs(Long.parseLong(calculationArrayList.get(0)));
        
        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));
        
        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate_plus(calculationArrayList); // + 계산
        calculationArrayList = calculate_minus(calculationArrayList); // - 계산
        calculationArrayList = calculate_multiple(calculationArrayList); // * 계산
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));
        
        
        return answer;
    }

    public ArrayList<String> convertToArraylist(String expression) {
        // 연산자를 기준으로 분리하고, 연산자도 배열에 포함시키기
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                tokens.add(number.toString());
                number = new StringBuilder();
                tokens.add(Character.toString(ch));
            } else {
                number.append(ch);
            }
        }
        if (number.length() > 0) {
            tokens.add(number.toString());
        }
        return new ArrayList<>(tokens);
    }

    public ArrayList<String> calculate_plus(ArrayList<String> calculationArrayList){
        return calculate(calculationArrayList, "+");
    }
    
    public ArrayList<String> calculate_minus(ArrayList<String> calculationArrayList){
        return calculate(calculationArrayList, "-");
    }
    
    public ArrayList<String> calculate_multiple(ArrayList<String> calculationArrayList){
        return calculate(calculationArrayList, "*");
    }
    
    private ArrayList<String> calculate(ArrayList<String> calculationArrayList, String operator) {
        for(int i = 1; i < calculationArrayList.size(); i+=2){
            if (calculationArrayList.get(i).equals(operator)){
                long number = 0;
                if (operator.equals("+")) {
                    number = Long.parseLong(calculationArrayList.get(i-1)) +
                             Long.parseLong(calculationArrayList.get(i+1));
                } else if (operator.equals("-")) {
                    number = Long.parseLong(calculationArrayList.get(i-1)) -
                             Long.parseLong(calculationArrayList.get(i+1));
                } else if (operator.equals("*")) {
                    number = Long.parseLong(calculationArrayList.get(i-1)) *
                             Long.parseLong(calculationArrayList.get(i+1));
                }
                calculationArrayList.set(i-1, String.valueOf(number));
                calculationArrayList.remove(i); // 현재 위치의 연산자 제거
                calculationArrayList.remove(i); // 연산 결과가 저장된 위치의 다음 요소 (원래 다음 숫자) 제거
                i-=2; // 다음 검사 위치 조정
            }
        }
        return calculationArrayList;
    }
}
