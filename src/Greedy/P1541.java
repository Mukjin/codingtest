package Greedy;

import java.util.Scanner;

public class P1541 {
    static int answer = 0; // 최종 결과 값을 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine(); // 사용자 입력을 받음

        // "-"(마이너스) 연산자를 기준으로 문자열을 나눔
        String[] str = example.split("-");

        // 첫 번째 그룹은 더하고, 이후 그룹은 빼는 방식으로 처리
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]); // 각 그룹의 합을 계산
            if (i == 0) answer += temp; // 첫 번째 그룹은 더함
            else answer -= temp; // 이후 그룹은 빼줌
        }

        System.out.println(answer); // 최종 결과 출력
    }

    // 주어진 문자열에서 "+"(플러스) 연산자를 기준으로 숫자를 더하는 함수
    private static int mySum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]"); // "+"를 기준으로 숫자를 나눔

        // 나눈 숫자들을 모두 더함
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum; // 계산된 합을 반환
    }
}
