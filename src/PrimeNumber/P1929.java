package PrimeNumber;

import java.util.Scanner;

public class P1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 입력: 시작 범위 M
        int N = sc.nextInt(); // 입력: 끝 범위 N
        int []A = new int[N+1]; // 소수를 판별하기 위한 배열 생성

        // 배열 초기화: 2부터 N까지 자신의 숫자로 초기화
        for(int i=2; i<N; i++){
            A[i] = i;
        }

        // 에라토스테네스의 체 알고리즘 적용
        for(int i=2; i<=Math.sqrt(N); i++){
            if(A[i] == 0) continue; // 이미 지워진 숫자는 건너뜀
            for(int j = i+i; j<=N; j=j+i){ // i의 배수를 모두 0으로 처리 (소수가 아님)
                A[j]=0;
            }
        }

        // M부터 N까지 소수 출력
        for(int i = M; i<=N; i++){
            if(A[i]!=0){ // 0이 아닌 경우 소수이므로 출력
                System.out.println(A[i]);
            }
        }
    }
}
