package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 배열의 크기 N을 입력받습니다.
        int N = sc.nextInt();

        // 크기가 N인 배열 A를 생성합니다.
        int[] A = new int[N];

        // 배열 A에 N개의 정수를 입력받습니다.
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        // 배열 A를 오름차순으로 정렬합니다.
        Arrays.sort(A);

        // 찾아야 할 숫자의 개수 M을 입력받습니다.
        int M = sc.nextInt();

        // M개의 숫자를 하나씩 입력받아 배열 A에 있는지 확인합니다.
        for(int i = 0; i < M; i++){
            boolean find = false; // 찾았는지 여부를 저장할 변수
            int target = sc.nextInt(); // 찾을 숫자를 입력받습니다.

            // 이진 탐색을 위한 시작과 끝 인덱스 설정
            int start = 0;
            int end = A.length - 1;

            // 이진 탐색 수행
            while(start <= end){
                int mid_index = (start + end) / 2; // 중간 인덱스 계산
                int mid_value = A[mid_index]; // 중간 인덱스의 값

                if(mid_value > target){
                    // 중간 값이 타겟보다 크면, 왼쪽 절반을 탐색
                    end = mid_index - 1;
                } else if(mid_value < target){
                    // 중간 값이 타겟보다 작으면, 오른쪽 절반을 탐색
                    start = mid_index + 1;
                } else {
                    // 중간 값이 타겟과 같으면, 찾았음을 표시하고 반복 종료
                    find = true;
                    break;
                }
            }

            // 찾았으면 1을 출력, 아니면 0을 출력
            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}