import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            // 점화식
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.println(dp[n]);

    }
}

//참고 : mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다. (오버플로우 방지)