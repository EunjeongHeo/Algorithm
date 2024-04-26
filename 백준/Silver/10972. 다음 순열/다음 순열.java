import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        // 효율적인 입력 처리를 위해 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()) {
            // 출력 부분을 StringBuilder를 사용하여 성능 개선
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation() {
        // 뒤에서부터 오름차순이 깨지는 지점 찾기
        int i = N - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i <= 0) {
            return false; // 마지막 순열인 경우
        }

        // i-1 위치와 교환할 더 큰 수 찾기
        int j = N - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swap(i - 1, j);

        // i 위치부터 끝까지 순서 뒤집기
        j = N - 1;
        while (i < j) {
            swap(i, j);
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
