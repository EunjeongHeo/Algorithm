import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = 0;	// 자리수 카운트
        int plusCount = 1;	// 각 숫자의 자리수
        int num = 10;	// 자리수 바뀌는 시점 기준
        int N = Integer.parseInt(bf.readLine());
        for(int i=1; i<=N; i++) {
            if(i%num == 0) { //자리수 바뀌는 시점 10, 100, 1000, ...
                plusCount += 1;
                num *= 10;
            }
            totalCount += plusCount;
        }
        System.out.println(totalCount);
        bf.close();
    }
}
