import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N; // 인원 수
    static int[][] score; // 능력치 2차원 배열

    static ArrayList<Integer> teamA = new ArrayList<>(); //스타트팀
    static ArrayList<Integer> teamB = new ArrayList<>(); //링크팀
    static boolean[] inTeamA; // 팀 A에 속한지를 확인하는 배열

    static int minScore = Integer.MAX_VALUE; // 팀 간 능력치 차이의 최소값

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        inTeamA = new boolean[N]; // 초기화

        // score 2차원 배열에 능력치 입력 받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, N/2);

        System.out.println(minScore);
    }

    private static void recursive(int order, int teamNumber) {

        // teamB 구성 <- teamA에 N/2만큼의 사람이 추가 완료 되었으면, teamA에 속하지 않은 사람들을 모두 teamB에 추가.
        if (teamNumber == 0) {
            
            // teamB 비우기
            teamB.clear();

            // teamB에 추가
            for (int i = 0; i < N; i++) {
                if (!inTeamA[i]) {
                    teamB.add(i);
                }
            }

            // 점수 격차 계산
            checkScore();
            
            return;
        }

        // teamA 구성
        for (int i = order; i < N; i++) {

            // i 사람 추가
            teamA.add(i);
            inTeamA[i] = true;

            // i+1 사람 추가하기 위해 재귀호출
            recursive(i + 1, teamNumber - 1);

            // 마지막에 합류하는 사람 제거
            teamA.remove(teamA.size() - 1);
            inTeamA[i] = false;
        }
    }

    // 점수 격차 계산
    private static void checkScore() {
        int teamA_score = 0, teamB_score = 0;

        // teamA, teamB의 모든 가능한 쌍에 대해 점수 계산
        for (int i = 0; i < N/2 - 1; i++) {
            for (int j = i + 1; j < N/2; j++) {
                int a1 = teamA.get(i);
                int a2 = teamA.get(j);
                int b1 = teamB.get(i);
                int b2 = teamB.get(j);
                teamA_score += score[a1][a2] + score[a2][a1];
                teamB_score += score[b1][b2] + score[b2][b1];
            }
        }

        // 팀 점수 차이 계산하고 최소값 업데이트
        int temp_result = Math.abs(teamA_score - teamB_score);
        minScore = Math.min(minScore, temp_result);
    }

}
