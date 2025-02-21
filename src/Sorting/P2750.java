package Sorting;

import java.util.Scanner;

public class P2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        // 배열에 N개의 정수를 입력받아 저장
        for (int i = 0; i < N; i++) {
            // 사용자로부터 정수를 입력받아 배열에 저장
            A[i] = sc.nextInt();
        }

        // 버블 정렬을 구현하는 영역
        // 외부 루프: 정렬이 끝날 때까지 반복 (최대 N-1번 패스)
        for (int i = 0; i < N - 1; i++) {
            // 내부 루프: 각 패스에서 인접한 요소를 비교하며 정렬
            // N-1-i: 이미 정렬된 마지막 i개의 요소는 비교할 필요 없음
            for (int j = 0; j < N - 1 - i; j++) {
                // 현재 요소가 다음 요소보다 크면 교환
                if (A[j] > A[j + 1]) {
                    int temp = A[j];     // 현재 요소를 임시 변수에 저장
                    A[j] = A[j + 1];     // 다음 요소를 현재 위치로 이동
                    A[j + 1] = temp;     // 임시 저장된 값을 다음 위치로 이동
                }
            }
        }

        // 정렬된 배열을 출력
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]); // 배열의 각 요소를 한 줄씩 출력
        }
        sc.close();
    }
}