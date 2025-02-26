package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1278 {
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        // 입력 처리 (N개의 행)
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 공백 없이 "10110..." 입력 가정
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0'; // char를 int로 변환
            }
        }

        BFS(0, 0);
        System.out.println(A[N-1][M-1]); // 도착점까지의 최단 거리 출력
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 경계 체크
                    if (A[nx][ny] != 0 && !visited[nx][ny]) { // 벽이 아니고 방문하지 않음
                        visited[nx][ny] = true;
                        A[nx][ny] = A[x][y] + 1; // 거리 증가
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}