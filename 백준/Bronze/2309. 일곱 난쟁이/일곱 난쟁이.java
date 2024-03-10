import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        int[] height = new int[9];
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<9;i++){
            height[i] = scanner.nextInt();
        }

        findFakeDwarfs(height);

        sortHeight(height);

        for(int i = 2; i < 9; i++) {
            System.out.println(height[i]);
        }
    }

    private static void findFakeDwarfs(int[] height) {

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

    private static void sortHeight(int[] height) {
        Arrays.sort(height);
    }

}
