

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] numArr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];


        //일반 숫자 배열 생성
        for(int i = 1; i <= N ; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1 ; j <= N ; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //구간합 배열 생성
        for(int i = 1; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + numArr[i][j];
            }
        }

        //입력 및 출력
        for(int i = 1; i <= M ; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1]);
        }
    }
}