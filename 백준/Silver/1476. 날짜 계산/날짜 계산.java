import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt(); // 1 ≤ E ≤ 15
        int S = scanner.nextInt(); // 1 ≤ S ≤ 28
        int M = scanner.nextInt(); // 1 ≤ M ≤ 19

        int year = 0;

        while(true){
            year++;
            if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
                System.out.println(year);
                break;
            }
        }

    }
}