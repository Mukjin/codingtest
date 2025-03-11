package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean IsEven;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;

            // check 배열 초기화 (-1: 미방문 상태)
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
                check[i] = -1;
            }

            // 에지 데이터 저장하기
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행해야 함 (연결 그래프가 아닐 수도 있음)
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    check[i] = 0; // 첫 번째 그룹을 0으로 설정
                    DFS(i);
                }
            }

            System.out.println(IsEven ? "YES" : "NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) { // 인접 리스트로 받아서 start에서 연결된 모든 노드 탐색
            if (!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else {
                if (check[start] == check[i]) {
                    IsEven = false;
                }
            }
        }
    }
}
