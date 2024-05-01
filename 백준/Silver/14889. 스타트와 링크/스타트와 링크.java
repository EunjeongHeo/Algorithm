import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N; // 인원 수
    static int[][] score; // 능력치 2차원 배열

    static ArrayList<Integer> teamA = new ArrayList<>(); // 스타트팀
    static boolean[] inTeamA; // 팀 A에 있는지 여부를 추적하는 배열

    static int minScore = Integer.MAX_VALUE; // 팀 간 능력치 차이의 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        inTeamA = new boolean[N];

        // score 2차원 배열에 능력치 입력 받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, N / 2);
        System.out.println(minScore);
    }

    private static void recursive(int order, int teamNumber) {
        if (teamNumber == 0) {
            // 점수 격차 계산
            checkScore();
            return;
        }

        for (int i = order; i <= N - teamNumber; i++) {
            teamA.add(i);
            inTeamA[i] = true;
            recursive(i + 1, teamNumber - 1);
            teamA.remove(teamA.size() - 1);
            inTeamA[i] = false;
        }
    }

    private static void checkScore() {
        ArrayList<Integer> teamB = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!inTeamA[i]) {
                teamB.add(i);
            }
        }

        int teamA_score = 0, teamB_score = 0;
        for (int i = 0; i < teamA.size(); i++) {
            for (int j = i + 1; j < teamA.size(); j++) {
                int a1 = teamA.get(i), a2 = teamA.get(j);
                teamA_score += score[a1][a2] + score[a2][a1];
            }
        }

        for (int i = 0; i < teamB.size(); i++) {
            for (int j = i + 1; j < teamB.size(); j++) {
                int b1 = teamB.get(i), b2 = teamB.get(j);
                teamB_score += score[b1][b2] + score[b2][b1];
            }
        }

        int temp_result = Math.abs(teamA_score - teamB_score);
        minScore = Math.min(minScore, temp_result);
    }
}
