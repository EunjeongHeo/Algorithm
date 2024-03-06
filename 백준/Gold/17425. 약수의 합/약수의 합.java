import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_NUM = 1000001;
    public static void main(String[] args) throws IOException {

        //약수의 합 배열 생성
        long[] nums = new long[MAX_NUM];
        //약수의 합을 계산하여 배열에 저장
        for (int i = 1; i < MAX_NUM; i++) {
            int n = 1;
            nums[i] += nums[i-1]; //이전까지의 약수의 합을 현재 약수의 합에 누적하여 저장
            while (i * n < MAX_NUM) {
                nums[i * n++] += i; //현재 수의 배수 인덱스에 현재수 합산
            }
        }

        //반복횟수를 입력받고, 주어진 반복 횟수만큼 약수의 합을 찾아 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            sb.append(nums[Integer.parseInt(br.readLine())]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }
}