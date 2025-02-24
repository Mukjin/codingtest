package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
    static boolean[] visited; // 방문 여부를 체크하는 배열
    static ArrayList<Integer>[] A; // 인접 리스트로 그래프를 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력을 공백으로 분리

        // 노드 수(n)와 간선 수(m) 입력 받기
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // visited 배열과 인접 리스트 초기화
        visited = new boolean[n + 1]; // 노드 번호가 1부터 시작하므로 n+1 크기로 생성
        A = new ArrayList[n + 1]; // 각 노드에 연결된 노드들을 저장할 인접 리스트 배열
        for (int i = 1; i <= n; i++) { // 노드 번호 1부터 n까지 초기화
            A[i] = new ArrayList<>(); // 각 노드에 빈 ArrayList 생성
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < m; i++) { // m개의 간선을 입력받아 그래프 구성
            st = new StringTokenizer(br.readLine()); // 각 줄을 공백으로 분리
            int s = Integer.parseInt(st.nextToken()); // 시작 노드
            int e = Integer.parseInt(st.nextToken()); // 끝 노드
            A[s].add(e); // s에서 e로 가는 간선 추가 (무방향 그래프)
            A[e].add(s); // e에서 s로 가는 간선 추가 (무방향 그래프)
        }

        // 연결 요소 개수 세기
        int count = 0; // 연결 요소 개수를 저장할 변수
        for (int i = 1; i <= n; i++) { // 모든 노드를 순회하며 방문 여부 확인
            if (!visited[i]) { // 방문하지 않은 노드라면
                count++; // 새로운 연결 요소 발견
                DFS(i); // DFS로 해당 노드와 연결된 모든 노드 방문
            }
        }
        System.out.println(count); // 최종 연결 요소 개수 출력
    }

    // DFS 메서드: 깊이 우선 탐색으로 연결된 노드들을 방문
    private static void DFS(int v) {
        if (visited[v]) { // 이미 방문한 노드라면 종료
            return;
        }
        visited[v] = true; // 현재 노드를 방문 처리
        for (int i : A[v]) { // 현재 노드에 연결된 모든 노드를 순회
            if (!visited[i]) { // 연결된 노드가 방문되지 않았다면
                DFS(i); // 재귀적으로 DFS 호출
            }
        }
    }
}