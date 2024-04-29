import java.util.Scanner;

public class Main {

    static int[] numbers; // 사용자로부터 입력 받을 정수 배열
    private static int N; // 배열의 크기 (정수의 개수)
    private static int S; // 목표 합
    private static int answer = 0; // 조건을 만족하는 경우의 수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 정수의 개수 (배열의 크기)
        S = scanner.nextInt(); // 목표 합
        numbers = new int[N]; // 저장할 정수 배열

        // 정수를 하나씩 입력 받아 배열에 저장
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // dfs 함수 최초 호출 (시작 깊이 0, 초기 합 0)
        dfs(0, 0);

        // S가 0인 경우 공집합도 합이 0이므로 1을 빼서 출력
        if (S == 0) System.out.println(answer - 1);

        // 그 외의 경우는 조건을 만족하는 경우의 수 그대로 출력
        else System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        // 모든 정수를 고려했다면
        if (depth == N) {
            // 현재 합이 목표 합과 같은지 검사
            if (sum == S) answer++; // 같다면 경우의 수를 증가
            return;
        }

        // 현재 정수를 포함하는 경우
        dfs(depth + 1, sum + numbers[depth]);

        // 현재 정수를 포함하지 않는 경우
        dfs(depth + 1, sum);
    }
}