package Sorting;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()]; // 입력된 문자열 길이만큼의 정수 배열 생성

        // 문자열을 한 글자씩 잘라서 정수로 변환하여 배열에 저장
        for(int i=0; i<str.length(); i++){
            // i번째 문자를 정수로 변환
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }

        // 선택 정렬(Selection Sort)을 이용해 내림차순 정렬
        for(int i=0; i<str.length(); i++){
            // 현재 위치를 최대값 인덱스로 초기화
            int Max = i;
            // i+1부터 끝까지 탐색하며 최대값 찾기
            for(int j = i+1; j<str.length(); j++){
                // 더 큰 값이 있으면 Max 갱신
                if(A[j] > A[Max]){
                    Max = j;
                }
            }
            // 현재 위치의 값이 최대값보다 작으면 교환
            if(A[i] < A[Max]){
                int temp = A[i]; // 임시 변수에 현재 값 저장
                A[i] = A[Max];   // 현재 위치에 최대값 배치
                A[Max] = temp;   // 최대값 위치에 원래 값 배치
            }
        }

        // 정렬된 배열 출력
        for(int i = 0; i<str.length(); i++){
            System.out.println(A[i]); // 각 숫자를 한 줄씩 출력
        }
    }
}