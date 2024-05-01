import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] numbers = new boolean[21];

    public static void main(String[] args) throws IOException {

        // 연산의 수 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        // StringBuilder 선언
        StringBuilder sb = new StringBuilder();

        // 연산자, 피연산자 입력 받고 처리
        while( M-- > 0 ){ // M번 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken(); // 연산자

            if (operator.equals("add") || operator.equals("remove") || operator.equals("check") || operator.equals("toggle")) {
                int operand = Integer.parseInt(st.nextToken()); // 피연산자
                switch (operator) {
                    case "add":
                        add(operand);
                        break;
                    case "remove":
                        remove(operand);
                        break;
                    case "check":
                        sb.append(check(operand)).append('\n');;
                        break;
                    case "toggle":
                        if (check(operand) == 1)
                            remove(operand);
                        else
                            add(operand);
                        break;
                }
            }

            else if ( operator.equals("all") ){
                Arrays.fill(numbers, true);
            }
            else if ( operator.equals("empty") ){
                Arrays.fill(numbers, false);
            }
        }

				// StringBuilder 출력
        System.out.println(sb);

    }

    private static int check(int operand) {
        // 중복 체크 (중복 시 1, 미중복시 0 반환)
        if (numbers[operand] == true)
            return 1;
        else
            return 0;
    }

    private static void remove(int operand) {
        // 중복 체크 (미중복 시 그냥 return)
        if( check(operand) == 0){
            return;
        }
        // 중복 시 요소 제거
        numbers[operand] = false;
    }

    private static void add(int operand) {
        // 중복 체크 (중복 시 그냥 return)
        if( check(operand) == 1){
            return;
        }
        // 미중복 시 요소 추가
        numbers[operand] = true;
    }


}
