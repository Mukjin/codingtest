package Graph;

import java.util.Scanner;

public class P1717 {
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1]; // 배열 전역 변수 사용
        for (int i = 0; i <= N; i++) { // 0부터 N까지 대표 노드 초기화
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) { // 연산 수행
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (question == 0) { // union 연산
                union(a, b);
            } else { // 같은 집합인지 확인
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        sc.close(); // Scanner 자원 해제
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a; // 루트 노드를 통일
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]); // 경로 압축 적용
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }
}
