import java.util.*;
import java.util.regex.*;

class Solution {
    public long solution(String expression) {
        ArrayList<String> calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList, "*");
        calculationArrayList = calculate(calculationArrayList,"+");
        calculationArrayList = calculate(calculationArrayList, "-");
        long answer = Math.abs(Long.parseLong(calculationArrayList.get(0)));
        
        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList, "*");
        calculationArrayList = calculate(calculationArrayList, "-");
        calculationArrayList = calculate(calculationArrayList, "+");
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));
        
        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList, "-");
        calculationArrayList = calculate(calculationArrayList,"*");
        calculationArrayList = calculate(calculationArrayList,"+");
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList, "-");
        calculationArrayList = calculate(calculationArrayList, "+");
        calculationArrayList = calculate(calculationArrayList, "*");
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList,"+");
        calculationArrayList = calculate(calculationArrayList,"*");
        calculationArrayList = calculate(calculationArrayList,"-");
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));

        calculationArrayList = convertToArraylist(expression);
        calculationArrayList = calculate(calculationArrayList,"+");
        calculationArrayList = calculate(calculationArrayList,"-");
        calculationArrayList = calculate(calculationArrayList,"*");
        answer = Math.max( answer, Math.abs(Long.parseLong(calculationArrayList.get(0))));
        
        
        return answer;
    }

    public ArrayList<String> convertToArraylist(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        // 숫자 또는 연산자와 일치하는 패턴
        Pattern pattern = Pattern.compile("\\d+|[\\+\\-\\*]");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
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
