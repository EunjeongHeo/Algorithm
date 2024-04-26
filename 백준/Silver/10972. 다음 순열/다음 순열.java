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
        nums = new int[N];  // 순열을 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());  // 순열을 입력받아 배열에 저장
        }

        // 다음 순열을 계산하고 결과를 출력합니다.
        if (nextPermutation()) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num).append(" ");  // 다음 순열이 존재하면 순열을 출력용 문자열로 만들기
            }
            System.out.println(sb.toString().trim());  // 공백을 제거하고 출력
        } else {
            System.out.println("-1");  // 다음 순열이 없으면 -1을 출력
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
        swap(i - 1, j);  // 찾은 지점을 서로 교환

        // i 위치부터 끝까지 순서 뒤집기
        j = N - 1;
        while (i < j) {
            swap(i, j);  // 나머지 부분을 뒤집어 사전순으로 다음 순서를 만들기
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
