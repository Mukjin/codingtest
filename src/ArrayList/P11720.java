package ArrayList;

import java.util.Scanner;
// 숫자의 합 구하기
public class P11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에 입력된 숫자의 자릿수 N을 입력받음
        int N = sc.nextInt();

        // 두번째 줄에 입력된 숫자를 입력받음
        String sNum = sc.next();

        // 문자열을 문자 배열로 변환
        char[] cNum = sNum.toCharArray();

        // 문자열을 문자 배열로 변환해서 각 자릿수 합을 구함.
        int sum = 0;
        for(int i = 0; i<cNum.length; i++){
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
