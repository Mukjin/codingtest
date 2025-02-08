package ArrayList;

import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 정수 N 입력 (시험 과목의 개수)
        int N = sc.nextInt();

        // 길이가 N인 정수 배열 A 선언
        int A[] = new int[N];

        // 배열에 점수 입력
        for (int i = 0; i < N; i++) {
        // 점수를 입력받아 배열 A에 저장
            A[i] = sc.nextInt();
        }

				// 점수 합계를 저장할 변수 (long 타입 사용)
        long sum = 0;
        // 최고 점수를 저장할 변수
        long max = 0;

        // 최대값 찾기 및 합계 계산
        for (int i = 0; i < N; i++) {
		        // 현재 값이 max보다 크면 max 갱신
            if (A[i] > max) max = A[i];
            // 점수를 sum에 더함
            sum = sum + A[i];
        }

        // 평균을 조정된 점수로 변환하여 출력
        System.out.println(sum * 100.0 / max / N);
    }
}
