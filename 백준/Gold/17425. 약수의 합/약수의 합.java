import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] nums = new long[1000001];
        Arrays.fill(nums, 1);

        for (int i = 2; i <= 1000000; i++) {
            //nums[i]에는 1부터 i-1까지의 값들의 배수에 해당된다면 그 값들이 합산되어 저장되어 있음.
            for (int j = 1; i * j <= 1000000; j++) {
                nums[i * j] += i; //i의 배수 번째 칸에 i 값 누적
            }

            //nums[i] = nums[i] + nums[i-1]
            //g(x)    = f(x)    + g(x-1)
            nums[i] += nums[i - 1]; //i번째 칸에 i-1번째 칸의 값 누적
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(n-- > 0) {
            answer.append(nums[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(answer);
    }
}
