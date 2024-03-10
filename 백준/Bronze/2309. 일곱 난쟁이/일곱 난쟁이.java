import java.util.Arrays;
import java.util.Scanner;

// [문제 설명]
// 진짜 일곱 난쟁이의 키의 합이 100.
// 아홉 난쟁이의 키가 주어졌을 때, 진짜 일곱 난쟁이를 찾기.

// [풀이]
// 9명 중 2명을 제외해서 100이 되는 경우를 따지자. (즉, 7명 선택이 아닌 2명 선택)
// 2명을 찾는 코드는 이중 반복문으로 처리해주었다.

public class Main {
    public static void main(String[] args) {

        int[] height = new int[9];
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<9;i++){
            height[i] = scanner.nextInt();
        }

        findByDwarfs(height);

        orderByHeight(height);

        for(int i = 2; i < 9; i++) {
            System.out.println(height[i]);
        }
    }

    private static void findByDwarfs(int[] height) {

        int sum = 0;
        for (int h : height) {
            sum += h;
        }

        for(int i = 0; i< 9;i++){
            for (int j = i+1; j<9;j++){
                if((sum - height[i] - height[j]) == 100){
                    height[i] = 0;
                    height[j] = 0;
                    return;
                }
            }
        }

    }

    private static void orderByHeight(int[] height) {
        Arrays.sort(height);
    }

}
