package Greedy;

import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 동전의 개수, K: 만들어야 할 금액
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 동전의 가치를 저장할 배열 A
        int A[] = new int[N];

        // 동전의 가치를 입력받음
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        // 그리디 알고리즘 -> 가치가 큰 동전부터 사용하여 최소 개수로 K를 만든다.
        int count = 0;

        // 큰 가치의 동전부터 확인 (내림차순 탐색)
        for(int i = N - 1; i >= 0; i--){
            if(A[i] <= K){ // 현재 동전이 K보다 작거나 같을 때만 사용 가능
                count += (K / A[i]); // 해당 동전으로 만들 수 있는 최대 개수를 더함
                K = K % A[i]; // 남은 금액 갱신
            }
        }

        // 최소 동전 개수 출력
        System.out.println(count);
    }
}
