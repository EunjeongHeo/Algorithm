import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];  // 순열을 저장할 배열
        visited = new boolean[N + 1];  // 방문 여부를 체크할 배열

        // 사전순으로 첫 번째 순열을 생성합니다.
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        do {
            // 현재 순열 출력
            for (int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        } while (nextPermutation());  // 다음 순열이 있을 때까지 반복
    }

    private static boolean nextPermutation() {
        // 뒤에서부터 오름차순이 깨지는 지점 찾기
        int i = N - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i <= 0) {
            return false; // 다음 순열이 없는 경우, 모든 순열을 출력했으므로 false 반환
        }

        // i-1 위치와 교환할 더 큰 수를 찾기
        int j = N - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swap(i - 1, j);  // 찾은 지점을 서로 교환

        // i 위치부터 끝까지 순서 뒤집기
        j = N - 1;
        while (i < j) {
            swap(i, j);  // 나머지 부분을 뒤집어 다음 사전순 순열 생성
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
